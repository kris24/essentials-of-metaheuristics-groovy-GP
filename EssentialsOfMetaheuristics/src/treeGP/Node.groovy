package treeGP

class Node {
    
    Node right
    Node left
         
    def arityTwo = ['+', '-', '/', '*']
    def arityOne = ['sin', 'cos', 'tan']
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
    
    
    
    def Node(value, left = NullNode.instance(), right = NullNode.instance()) {
        this.value = value
        arity = assignArity(value)
        isOperator = (arity != 0)
        isVar = (!value.getClass() == String && !isOperator)
    }
    
    def isLeaf() {
        return left == NullNode.instance() && right == NullNode.instance()
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
    
    String toString(){
        return value.toString()
    }
    def isNull() {
        return false
    }
    
    
}