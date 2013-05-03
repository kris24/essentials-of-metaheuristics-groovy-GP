package applications.robocode

class Template implements Cloneable {
	
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
	
	def Template(identity) {

		id = identity
		
		evolvedProperties = [
			["setAhead(180);", "setAhead(getGunHeading());", "back(getHeading());", "turnLeft(getVelocity());"],
			["setBack(move);", "setTurnRight(getEnergy());", "move=getY();"],
			["if(getEnergy()==getVelocity()){ setAhead(getX()); }"],
			["setBack(getX());", "move=getEnergy();"],
			["setBack(move);", "setTurnRight(getEnergy());", "move=getY() ;"],
			["if(getEnergy()==getVelocity()){ setAhead(getX()); }" ]			
			]
			
			
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
		//System.out.println("Code Array  " + codeArray)
		assignCode(codeArray)
		assignVals()
		//System.out.println("Done")
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
