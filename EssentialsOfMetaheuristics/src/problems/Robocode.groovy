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
		id = "12"
		
		for ( i in 0..6 ) {
		movementFactory = new MovementFactory()
		evolvedProperties[i] = movementFactory.returnRobot()
		}
		codeRun = code[0]
		codeWall = code[1];
		codeCollision = code[2];
		codeReceiveHit = code[3];
		codeHit = code[4];
		codeMiss = code[5];
		
		def values = ["id" : id, "codeRun" : codeRun,
			"codeWall" : codeWall,
			"codeCollision" : codeCollision,
			"codeReceiveHit" : codeReceiveHit,
			"codeHit" : codeHit,
			"codeMiss" : codeMiss ]
		
	}
	
	def copy = { a -> a.clone() }
	
	def random = create
	
	def quality() {
		robotBuilder = new RobotBuilder("templates/DarkSouls.template")
		robotBuilder.buildJarFile(values)
		
		battleRunner = new BattleRunner("templates/battle.template")
		
		battleRunner.buildBattleFile(id)
		
		def score = battleRunner.runBattle(id)
		
		System.out.println(score)
		
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