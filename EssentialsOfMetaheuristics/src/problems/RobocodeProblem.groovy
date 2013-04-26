package problems

import applications.robocode.*

class RobocodeProblem {
	Integer evalCount = 0
	Integer maxIterations = 1000
	
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
		Random random = new Random()
		id = random.nextInt(1000)
		
		individual = new Individual(id)
		
	}
	
	def copy = { a -> a.clone() }
	
	def random = create
	
	def quality(i) {
		def score
		if (i.score == null){
		
		System.out.println("Building a robot")
		robotBuilder = new RobotBuilder("templates/DarkSouls.template")
		robotBuilder.buildJarFile(individual.values)
		System.out.println("Building with values   " + i.values)
		
		battleRunner = new BattleRunner("templates/battle.template")
		
		battleRunner.buildBattleFile(id)
		
		score = battleRunner.runBattle(id)
		i.score = score
		}
		
		System.out.println("Score   " + score)
		return score
		
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

