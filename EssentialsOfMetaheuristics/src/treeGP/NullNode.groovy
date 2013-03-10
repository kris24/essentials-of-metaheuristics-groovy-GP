package treeGP

class NullNode {
    
    
    private static def instance = new NullNode();
    
    private NullNode() {
             // Any initialization code - hopefully little or none.
    }
    
    static def instance() {
        return this.instance
    }
	
	def clone() {
		return this.instance
	}
    

	
    def insert(key, value) {
        return new Node(data)
    }
    
    def isNull() {
        return true
    }
    
    def size() {
        return 0
    }
    
    def depth() {
        return 0
    }
    
    def search(key) {
        return null
    }
    
    def getLeft() {
        throw new UnsupportedOperationException()
    }
    
    def getRight() {
        throw new UnsupportedOperationException()
    }
    
}
