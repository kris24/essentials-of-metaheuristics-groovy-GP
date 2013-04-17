package applications.robocode


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
		def string1 = "setAhead(90);  turnRight(360);  setBack(180);  "
		def string2 = "if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop(); "
		resultstr = roboCrossover.crossover(string1,string2)
		
		then:
		System.out.println("TEST: \n" + resultstr)
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
		System.out.println("\n" + resultstr)
	}
}

