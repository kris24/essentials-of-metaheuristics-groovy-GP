package applications.robocode

class Individual implements Cloneable {
	
	def evolvedProperties = []
	def values
	def quality
	def movementFactory
	
	//Template Values
	def id
	def codeRun
	def codeWall
	def codeCollision
	def codeReceiveHit
	def codeHit
	def codeMiss
	
	def Individual(identity) {

		id = identity
		
		for ( i in 0..6 ) {
			movementFactory = new MovementFactory()
			evolvedProperties[i] = movementFactory.returnRobot()
			}
			
	}
	
	def codify() {
		for (item in evolvedProperties){
			evolvedProperties[item] = toStr(item)
		}
		assignCode()
		assignVals()
	}
	def toStr(arr) {
		System.out.println(arr)
		def code = ""
		for (item in arr) {
			code + item
		}
		return code
	}
	
	def assignCode() {
		System.out.println(evolvedProperties)
		codeRun = evolvedProperties[0]
		codeWall = evolvedProperties[1]
		codeCollision = evolvedProperties[2]
		codeReceiveHit = evolvedProperties[3]
		codeHit = evolvedProperties[4]
		codeMiss = evolvedProperties[5]
	}
	
	
	
	def assignVals() {
			values = ["id" : id, "codeRun" : codeRun,
			"codeWall" : codeWall,
			"codeCollision" : codeCollision,
			"codeReceiveHit" : codeReceiveHit,
			"codeHit" : codeHit,
			"codeMiss" : codeMiss ]
	}
		
	
	
}
