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
		def codeArray = []
		for (item in evolvedProperties){
			def code = ""
			for (p in item) {
				code = code + p
			}
			codeArray.add(code)
		}
		System.out.println("Code Array  " + codeArray)
		assignCode(codeArray)
		assignVals()
		System.out.println("Done")
	}
	
	def assignCode(arr) {
		codeRun = arr[0]
		codeWall = arr[1]
		codeCollision = arr[2]
		codeReceiveHit = arr[3]
		codeHit = arr[4]
		codeMiss = arr[5]
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
