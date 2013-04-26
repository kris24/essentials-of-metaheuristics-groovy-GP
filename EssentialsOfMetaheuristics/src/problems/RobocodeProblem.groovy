package problems

import applications.robocode.*

class RobocodeProblem {
	Integer evalCount = 0
	Integer maxIterations = 1000
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
		
		individual = new Individual(id)
		
	}
	
	def copy = { a -> a.clone() }
	
	def random = create
	
	def quality(i) {
		def score = i.quality
		if (i.quality == null){
		
		System.out.println("Building robot DarkSoul_" +  i.id)
		robotBuilder = new RobotBuilder("templates/DarkSouls.template")
		robotBuilder.buildJarFile(i.values)
		System.out.println("Building with values   " + i.values)
		
		battleRunner = new BattleRunner("templates/battle.template")
		
		battleRunner.buildBattleFile(i.id)
		
		score = battleRunner.runBattle(i.id)
		i.quality = score
		}
		
		System.out.println("Score for DarkSoul_" + i.id + ": " + score)
		return i
		
	}
	
	def tweak = {
		
	}
	
	def perturb() {

	}

    def terminate = { a, q = quality(a) ->
        evalCount >= maxIterations
    }

	String toString() {

	}
}

