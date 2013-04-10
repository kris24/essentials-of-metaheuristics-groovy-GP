package applications.robocode

class Node{
	def index
	def children
	def parent
	def depth
	def value
	int arity
	
	def node(val, par){
		value = val
		parent = par
		children= []
		
	}
	
	def node(val){
		value = val
		parent = null
		depth = 0
		children = []
	}
}