package experiments

import problems.SinApproximation
import populationMethods.GeneticAlgorithm

class ExperimentRunner {

    static runExperiment(searchers, problems, numRuns = 30) {
        for (p in problems) {
            for (s in searchers) {
                for (i in 0..<numRuns) {
                    p.evalCount = 0
                    def result = s.minimize(p)
                    println "${s.toString()}\t${p.toString()}\t${p.quality(result)}\t${result}"
                }
            }
        }
    }

    static main(args) {
        def searchers = [
            new GeneticAlgorithm()
        ]
        def problems = [
            
            new SinApproximation(treeDepth: 4)
        ]
        // It would be nice to collect the total time here and include it in the
        // output.
        runExperiment(searchers, problems)
    }

}
