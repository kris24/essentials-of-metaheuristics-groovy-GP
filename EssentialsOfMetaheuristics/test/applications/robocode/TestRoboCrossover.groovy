package applications.robocode


import spock.lang.Specification
class TestRoboCrossover extends Specification {
    
	def roboCrossover
	
	def items = []
	

	
	def setup() {
		roboCrossover = new RoboCrossover()
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
	
	def "Crossover"() {
		when:
		def string1 = "setAhead(90);  turnRight(360);  setBack(180);"
		def string2 = "if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop(); "
		def result1 = roboCrossover.makeArray(string1)
		def result2 = roboCrossover.makeArray(string2)
		
		items = roboCrossover.onePointCrossover(result1,result2)
		result1 = items[0]
		result2 = items[1]
		
		then:
		for ( i in result1 ) {
		System.out.println(result1[i])
		}
		for ( i in result2 ) {
		System.out.println(result2[i])
		}
		assert roboCrossover.onePointCrossover(result1, result2)
	}
	
	def "And back to String"() {
		when:
		def string1 = "setAhead(90);  turnRight(360);  setBack(180);"
		def string2 = "if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop(); "
		def result1 = roboCrossover.makeArray(string1)
		def result2 = roboCrossover.makeArray(string2)
		
		roboCrossover.onePointCrossover(result1,result2)
		def rString1 = roboCrossover.backToString(result1)
		def rString2 = roboCrossover.backToString(result2)
		
		then:
		true
		
	}
}

