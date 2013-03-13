package treeGP

import java.util.Random

class Node {

    Random rand = new Random()
    Node right
    Node left

    def arityTwo = ['+', '-', '/', '*']
    def arityOne = ['sin', 'cos', 'tan']
    def vars = ['x','y','z']
    def functionSet = arityOne + arityTwo + vars 
    def value
    def arity
    def isOperator
    def isVar


    def assignArity = { value ->
        if (arityTwo.contains(value)) {
            arity = 2
        } else if (arityOne.contains(value)){
            arity = 1
        } else {
            arity = 0
        }
    }


    //remove nullnode entirely, it doesn't seem to work
    def Node(value) {
        this.value = value
        arity = assignArity(value)
        isOperator = (arity != 0)
        isVar = (!value.getClass() == String && !isOperator)
    }



    def evaluate() {
        if (arity == 0) {
            return value
        }

        if (arity == 1) {
            // all arity-one functions have their child stored in the right node
            return evaluateArityOne(right)
        } else if (arity == 2) {
            return evaluateArityTwo(left, right)
        }

    }


    def evaluateArityTwo(lNode, rNode) {
        switch (value) {
            case '+':
                return lNode.evaluate() + rNode.evaluate()
            case '-':
                return lNode.evaluate() - rNode.evaluate()
            case '*':
                return lNode.evaluate() * rNode.evaluate()
            case '/':
                return lNode.evaluate() / rNode.evaluate()

        }
    }

    def evaluateArityOne(arg) {
        switch (value) {
            case 'sin':
                return Math.sin(arg.evaluate())
            case 'cos':
                return Math.cos(arg.evaluate())
            case 'tan':
                return Math.tan(arg.evaluate())
        }
    }

    def mutate() {

        if (arity == 2) {
            value = arityTwo[rand.nextInt(4)]
        } else if (arity == 1) {
            value = arityOne[rand.nextInt(3)]
        }



    }

    static Node crossover(Node a, Node b) {

        Node parentOne = a.clone()
        Node parentTwo = b.clone()

        Node headOne = parentOne.getRandomNode()
        Node headTwo = parentTwo.getRandomNode()

    }

    //    def getRandomNode(r = (rand.nextInt() % size())+1) {
    ////        boolean returnLeaf = rand.nextInt(10) == 0
    //
    //        if (left != null && r < left.size()) {
    //            return left.getRandomNode(r)
    //        } else if (right != null && r > right.size()) {
    //            return right.getRandomNode(r - (right.size() ))
    //        } else {
    //            return this.clone()
    //        }
    //
    //    }

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
        vars.add( rand.nextDouble().trunc(3) )
        if (d == maxDepth) {
            newNode = new Node(vars[rand.nextInt(vars.size)])
            return newNode
        } else {
            newNode = new Node(functionSet[rand.nextInt(functionSet.size)])
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
        if (right.depth() > left.depth()) {
            return right.depth() + 1
        }
        return left.depth() + 1
    }

    def clone() {
        Node head = new Node(value)
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