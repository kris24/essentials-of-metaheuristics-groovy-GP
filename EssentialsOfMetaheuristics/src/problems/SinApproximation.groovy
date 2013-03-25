package problems
import treeGP.Node
class SinApproximation {



    def rangeStart = 0.0
    def rangeEnd = Math.PI*2
    def samples = 100.0
    def maxIterations = 1000
    def evalCount = 0
    def sinPoints = []
    def treeDepth = 5

    def create = {
        Node.makeTree(treeDepth)
    }

    def random = {
        Node.makeTree(treeDepth)
    }

    def terminate = { best, bestQ ->
        evalCount >= maxIterations || bestQ == 0
    }

    def tweak = { n ->
        return n.mutate()
    }

    def copy = { n ->
        n.clone()
    }

    def quality = { n ->
        def total = 0
        def result = n.function(rangeStart, rangeEnd, samples)
        if (sinPoints.size() == 0){
            def step = (rangeEnd - rangeStart)/samples
            for (double i = rangeStart; i < rangeEnd; i += step) {
                sinPoints.add(Math.sin(i))
            }
        }
        for (i in sinPoints.size()-1) {
            def q = Math.abs(sinPoints.get(i) - result.get(i))
            total += q
        }
        return total/sinPoints.size()

    }


}