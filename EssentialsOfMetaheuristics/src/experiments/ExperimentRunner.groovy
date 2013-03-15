package experiments

import problems.SinApproximation
import singleStateMethods.HillClimber
import singleStateMethods.SteepestAscentHillClimber

class ExperimentRunner {

    static runExperiment(searchers, problems, numRuns = 30) {
        for (p in problems) {
            for (s in searchers) {
                for (i in 0..<numRuns) {
                    p.evalCount = 0
                    def result = s.maximize(p)
                    println "${s.toString()}\t${p.toString()}\t${p.quality(result)}\t${result}"
                }
            }
        }
    }

    static main(args) {
        def searchers = [
            new HillClimber(),
            new SteepestAscentHillClimber(numGradientSamples : 1),
            new SteepestAscentHillClimber(numGradientSamples : 2),
            new SteepestAscentHillClimber(numGradientSamples : 4),
        ]
        def problems = [
            
            new SinApproximation()
        ]
        // It would be nice to collect the total time here and include it in the
        // output.
        runExperiment(searchers, problems)
    }

}
