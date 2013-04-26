package applications.robocode

class Individual {

	def evolvedProperties = []
	def values
	def score
	def movementFactory
	
	//Template Values
	def id
	def codeRun
	def codeWall
	def codeCollision
	def codeReceiveHit
	def codeHit
	def codeMiss
	
	def Individual(identity){
		id = identity
		
		for ( i in 0..6 ) {
			movementFactory = new MovementFactory()
			evolvedProperties[i] = movementFactory.returnRobot()
			}
			codeRun = evolvedProperties[0]
			codeWall = evolvedProperties[1];
			codeCollision = evolvedProperties[2];
			codeReceiveHit = evolvedProperties[3];
			codeHit = evolvedProperties[4];
			codeMiss = evolvedProperties[5];
		
		values = ["id" : id, "codeRun" : codeRun,
			"codeWall" : codeWall,
			"codeCollision" : codeCollision,
			"codeReceiveHit" : codeReceiveHit,
			"codeHit" : codeHit,
			"codeMiss" : codeMiss ]
	}
	
}
