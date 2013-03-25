package problems
import treeGP.Node
class SinApproximation {



    def rangeStart = 0.0
    def rangeEnd = Math.PI*2
    def samples = 100.0
    def maxIterations = 20
    def evalCount = 0
    def sinPoints = getSinPoints()
    def treeDepth = 5
	
	def getSinPoints() {
		
		def points = []
		def counter = 0		
			def step = (rangeEnd - rangeStart)/samples
			for (double i = rangeStart; i < rangeEnd; i += step) {
				points.add(Math.sin(i))
				//println(points.last() + ", " + counter++)
			}
		
		return points
	}

    def create = {
        Node.makeTree(treeDepth)
    }

    def random = {
        Node.makeTree(treeDepth)
    }

    def terminate = { best, bestQ ->
        evalCount >= maxIterations || bestQ == 0.0
    }

    def tweak = { n ->
        return n.mutate()
    }

    def copy = { n ->
        n.clone()
    }

    def quality = { n ->
		evalCount++
        def total = 0
        def result = n.function(rangeStart, rangeEnd, samples)
        for (int i = 0; i < sinPoints.size(); i++) {
            def q = Math.abs(sinPoints[i] - result.get(i))
            println("SinPoints, Result  " + sinPoints[i] + ', ' + result[i] + ', ' + i)
			println(evalCount)
            total += q
        }
        return total/sinPoints.size()*100

    }
    
    


}