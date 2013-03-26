package treeGP

import java.util.Random

class Node {

    Random rand = new Random()
    Node right
    Node left

    def arityTwo = ['+', '-', '/', '*']
    def arityOne = [/*'sin', */'cos', 'tan']
    def vars
    def value
    def arity
    def isOperator
    def isVar
    def functionSet = arityOne + arityTwo + vars 


    def assignArity = { value ->
        if (arityTwo.contains(value)) {
            arity = 2
        } else if (arityOne.contains(value)){
            arity = 1
        } else {
            arity = 0
        }
    }


    def Node(value, vars = ['x']) {
        this.vars = vars
        this.value = value
        arity = assignArity(value)
        isOperator = (arity != 0)
        isVar = (value.getClass() == String && !isOperator)
    }



    def evaluate(varMap) {
        if (arity == 0) {
            if (isVar) {
                return varMap.get(value)
            }
            return value
        }

        if (arity == 1) {
            // all arity-one functions have their child stored in the right node
            return evaluateArityOne(right, varMap)
        } else if (arity == 2) {
            return evaluateArityTwo(left, right, varMap)
        }

    }


    def evaluateArityTwo(lNode, rNode, varMap) {
        switch (value) {
            case '+':
                return lNode.evaluate(varMap) + rNode.evaluate(varMap)
            case '-':
                return lNode.evaluate(varMap) - rNode.evaluate(varMap)
            case '*':
                return lNode.evaluate(varMap) * rNode.evaluate(varMap)
            case '/':
                if (rNode.evaluate(varMap) == 0){
                    return 1
                }
                return lNode.evaluate(varMap) / rNode.evaluate(varMap)

        }
    }

    def evaluateArityOne(arg, varMap) {
        switch (value) {
            case 'sin':
                return Math.sin(arg.evaluate(varMap))
            case 'cos':
                return Math.cos(arg.evaluate(varMap))
            case 'tan':
                return Math.tan(arg.evaluate(varMap))
        }
    }

    def mutate() {
        def base = getRandomNode()
        base = generateRandomTree(base.depth())
    }

    def function(rangeStart, rangeEnd, samples) {
        def step = (rangeEnd - rangeStart)/samples
        def results = []
        
        for(double i = rangeStart; i <= rangeEnd; i += step) {
            results.add(evaluate([x:i]))
        }
        
      return results
        
    }
    
    
    static crossover(a, b) {

        Node parentOne = a
        Node parentTwo = b

        Node headOne = parentOne.getRandomNode()
        Node headTwo = parentTwo.getRandomNode()
        
        def child1 = headOne.clone()
        child1.left = headTwo.clone()
        
        def child2 = headTwo.clone()
        child2.left = headOne.clone()
        
        return [child1, child2]

    }

    

    def getRandomNode() {
        Node firstNode = this
        def r = (rand.nextInt(depth()))
        def iterations = 0
        return getRandomNodeRecursive(r, iterations, firstNode)
    }

    def getRandomNodeRecursive(r, iterations, firstNode) {
        //println("depth " + r)
        //println("iterations " + iterations)

        int direction = rand.nextInt(2)
        if (iterations == r) {
            return this.clone()
        } else if (direction == 0) {
            iterations++
            if (left == null){
                return firstNode.getRandomNodeRecursive(r, iterations, firstNode)
            }
            return left.getRandomNodeRecursive(r, iterations, firstNode)
        } else if (direction == 1) {
            iterations++
            if (right == null){
                return firstNode.getRandomNodeRecursive(r, iterations, firstNode)
            }
            return right.getRandomNodeRecursive(r, iterations, firstNode)
        }
    }
    
    static makeTree(maxDepth){
        Node temp = new Node('+')
        return temp.generateRandomTree(maxDepth)
    }
    
    def generateRandomTree(maxDepth, d = 0) {
        def newNode
        vars.add( rand.nextInt(2)-rand.nextDouble().trunc(2) )
        vars.add('x')
        
        if (d == maxDepth) {
            newNode = new Node(vars[rand.nextInt(vars.size)], vars)
            return newNode
        } else {
            newNode = new Node(functionSet[rand.nextInt(functionSet.size)], vars )
            if (newNode.arity == 0) {
                return newNode
            } else if (newNode.arity == 1){
                newNode.right = generateRandomTree(maxDepth, d + 1)
                return newNode
            } else {
                newNode.left = generateRandomTree(maxDepth, d + 1)
                newNode.right = generateRandomTree(maxDepth, d + 1)
                return newNode
            }
        }
        
        
    }

    def size() {

        if (arity == 0) {
            return 1
        } else if (arity == 1) {
            return 1 + right.size()
        } else {
            return 1 + left.size() + right.size()
        }

    }

    def depth() {
        if (arity == 0) {
            return 1
        }
        if (left == null) {
            return right.depth() + 1
        }
        if (right.depth() > left.depth()) {
            return right.depth() + 1
        }
        return left.depth() + 1
    }

    def clone() {
        Node head = new Node(value, vars)
        if (left != null) {
            head.left = left.clone()
        }
        if (right != null) {
            head.right = right.clone()
        }
        return head
    }



    String toString(){
        if (arity == 0) {
            return value.toString()
        } else if (arity == 1) {
            return value.toString() + "("+ right.toString() + ")"
        }
        return "(" + left.toString() + " " +  value.toString() + " " + right.toString() + ")"
    }

    def isNull() {
        return false
    }


}