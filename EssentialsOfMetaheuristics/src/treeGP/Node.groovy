package treeGP

class Node {
    
    def right
    def left    
    def data
    //def arity = data
    
    def Node(data, left = NullNode.instance(), right = NullNode.instance()) {
        
    }
    
    def isOperand() {
        return left == NullNode.instance() && right == NullNode.instance()
    }
    
    def evaluate() {
        if (isOperand()) {
            return data
        } 
    }
    
    def isNull() {
        return false
    }
    
    def depth() {
        if (right.depth() > left.depth()) {
            return (right.depth() + 1)
        }
        return (left.depth() + 1)
    }
    
}