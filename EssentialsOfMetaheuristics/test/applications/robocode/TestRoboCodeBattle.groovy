package applications.robocode

import spock.lang.Specification


/*
 * This assumes that there is a copy of Robocode in your home directory,
 * and that it has been configured (via the GUI) to be able to load robot
 * files from the evolved_robots directory in this project.
 */
class TestRoboCodeBattle extends Specification {
	/*
	 * id : an id used in the generation of the name of the class.
	 * code* : evolved legal Java Code for each situation
	 */
	def id
	def codeRun
	def codeWall
	def codeCollision
	def codeReceiveHit
	def codeHit
	def codeMiss

	def robotBuilder
	def battleRunner
	def movementFactory
	def code = []

	def setup() {
		Random random = new Random()
		id = random.nextInt(1000)
		for ( i in 0..6 ) {
		movementFactory = new MovementFactory()
		code[i] = movementFactory.returnRobot()
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

		robotBuilder = new RobotBuilder("templates/DarkSouls.template")
		robotBuilder.buildJarFile(values)
		
		battleRunner = new BattleRunner("templates/battle.template")
	}
	
	def "Check that the battle file is correctly constructed"() {
		when:
		battleRunner.buildBattleFile(id)
		
		then:
		confirmBattleFile()
	}
	
	def "Check that we can run a battle and extract the scores"() {
		given:
		battleRunner.buildBattleFile(id)
		
        when:
		def score = battleRunner.runBattle(id)

        then:
		score >= 0
		//System.out.println("Score:  " + score);
	}
	
	def confirmBattleFile() {
		File file = new File("evolved_robots/evolve.battle")
        def contents = file.readLines()
        def interestingLines = contents.findAll { line ->
            (line.indexOf("robocode.battle.selectedRobots") >= 0)
        }
        assert interestingLines.size() == 1
		assert interestingLines[0].indexOf("sample.Walls") >= 0
        assert interestingLines[0].indexOf("evolved.DarkSoul_${id}") >= 0
        return true
	}
}
