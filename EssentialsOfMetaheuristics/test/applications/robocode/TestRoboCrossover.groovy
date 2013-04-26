package applications.robocode


import operators.RoboCrossover
import problems.RobocodeProblem
import spock.lang.Specification
class TestRoboCrossover extends Specification {
    
	def roboCrossover
	def roboCrossover2
	
	def resultstr

	

	
	def setup() {
		roboCrossover = new RoboCrossover()
	
	}

	def "test crossover operator"() {
		when:
		def robo1 = new RobocodeProblem()
		robo1.create()
		def robo2 = new RobocodeProblem()
		robo2.create()
		System.out.println("TESTSTART:  \n" + robo1.individual.evolvedProperties)
		resultstr = roboCrossover.crossover(robo1.individual,robo2.individual)
		
		then:
		System.out.println("TEST: \n" + resultstr.evolvedProperties)
	}
    
	def "Confirm that string split works"() {
		when:
		def string1 = "setAhead(90);  turnRight(360);  setBack(180);"
		def result1 = roboCrossover.makeArray(string1)
		
		then:
		assert result1[0] == "setAhead(90);"
		assert result1[1] == "turnRight(360);"
		assert result1[2] == "setBack(180);"
	}
	
	def "And back to String"() {
		when:
		def string1 = "  setAhead(90);  turnRight(360);  setBack(180);  setTurnRight(90);  "
		def string2 = "  if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop();  "
		def result1 = roboCrossover.makeArray(string1)
		def result2 = roboCrossover.makeArray(string2)
		
		def resultarr = []
		resultarr = roboCrossover.onePointCrossover(result1,result2)
		resultstr = roboCrossover.backToString(resultarr[0])
		
		then:
		System.out.println("\n") //+ resultstr)
	}
}

