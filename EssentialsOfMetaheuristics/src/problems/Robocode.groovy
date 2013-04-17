package problems

import applications.robocode.*

class Robocode {
	//Template Values
	def id
	def codeRun
	def codeWall
	def codeCollision
	def codeReceiveHit
	def codeHit
	def codeMiss
	
	//Classes
	def robotBuilder
	def movementFactory
	def battleRunner
	def evolvedProperties = []
	
	def create() {
		id = 
		
		movementFactory = new MovementFactory()
		evolvedProperties[i] = movementFactory.returnRobot()
	}
	
	def copy() {
		
	}
	
	def random() {
		
	}
	
	def quality() {
		
	}
	
	def tweak() {
		
	}
	
	def perturb() {

	}

	def terminate() {

	}

	String toString() {

	}
}