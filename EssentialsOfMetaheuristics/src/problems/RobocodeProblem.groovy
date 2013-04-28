package problems

import applications.robocode.*

class RobocodeProblem {
	Integer evalCount = 0
	Integer maxIterations = 4
	Integer IDcount = 0
	
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
	def code = []
	def individual
	
	def create = {
		id = IDcount++
		//Random random = new Random()
		//id = random.nextInt(1000)
		individual = new Individual(id)
		
	}
	
	def copy = { a -> a.clone() }
	
	def random = create
	
	def quality(i) {
		
		if (i.quality == null){
		def score = i.quality
		System.out.println("Building robot DarkSoul_" +  i.id)
		robotBuilder = new RobotBuilder("templates/DarkSouls.template")
		robotBuilder.buildJarFile(i.values)
		System.out.println("Building with values   " + i.values)
		
		battleRunner = new BattleRunner("templates/battle.template")
		
		battleRunner.buildBattleFile(i.id)
		
		score = battleRunner.runBattle(i.id)
		i.quality = score
		}
		return i.quality
		
	}
	
	def tweak = {
		
	}
	
	def perturb() {

	}

    def terminate(best) {
		evalCount++
        evalCount >= maxIterations
    }

	String toString() {
		"Robocode"
	}
}

