package problems
import treeGP.Node
class SinApproximation {



    def rangeStart = 0.0
    def rangeEnd = Math.PI*2
    def samples = 100.0
    def maxIterations = 1000
    def evalCount
    def sinPoints = []
    def treeDepth = 5
    def myNode 

    def SinApproximation(myNode = Node.makeTree(treeDepth)){
        this.myNode = myNode
    }
    
    def create = {
        
        
        return new SinApproximation()
    }
    
    def random = {
        return Node.makeTree(treeDepth)
        
    }
    
    def terminate = { best, bestQ ->
        evalCount >= maxIterations || bestQ == 0
    }
    
    def tweak = { n ->
        return n.mutate()
        
    }
    
    def copy = {
        return new SinApproximation(myNode)
    }
    
    def quality = { n ->
        def total = 0
        def result = n.myNode.function(rangeStart, rangeEnd, samples)
        
        def step = (rangeEnd - rangeStart)/samples
        for (double i = rangeStart; i < rangeEnd; i += step) {
            sinPoints.add(Math.sin(i))
        }
        
        for (i in sinPoints.size()-1) {
            def q = Math.abs(sinPoints.get(i) - result.get(i))
            total += q
        }
        return total/sinPoints.size()

    }


}