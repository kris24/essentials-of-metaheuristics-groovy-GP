package applications.robocode


import spock.lang.Specification
class TestRoboCrossover extends Specification {
    
	def roboCrossover
	def roboCrossover2
	
	def items = []
	

	
	def setup() {
		roboCrossover = new RoboCrossover()
	
	}

	def "test crossover operator"() {
		when:
		def string1 = "setAhead(90);  turnRight(360);  setBack(180);  "
		def string2 = "if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop(); "
		roboCrossover.crossover(string1,string2)
		
		then:
		System.out.println("TEST: \n" + string1 + "\n" + string2)
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
		def string1 = "setAhead(90);  turnRight(360);  setBack(180);  "
		def string2 = "if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop(); "
		def result1 = roboCrossover.makeArray(string1)
		def result2 = roboCrossover.makeArray(string2)
				
		then:
		
		for ( i in 0..5 ) {
			roboCrossover.onePointCrossover(result1,result2)
			//System.out.println(result1 )
			//System.out.println(result2)
		}

		assert roboCrossover.onePointCrossover(result1, result2)
	}
	
	def "And back to String"() {
		when:
		def string1 = "  setAhead(90);  turnRight(360);  setBack(180);  setTurnRight(90);  "
		def string2 = "  if(getEnergy()<getX()){ turnLeft(360); }  turnLeft(getVelocity());  ahead(90);  stop();  "
		def result1 = roboCrossover.makeArray(string1)
		def result2 = roboCrossover.makeArray(string2)
		
		def rString1
		def rString2
		
		then:
		for ( i in 0..5) {
			items = roboCrossover.onePointCrossover(result1,result2)
			result1 = items[0]
			result2 = items[1]
			rString1 = roboCrossover.backToString(result1)
			rString2 = roboCrossover.backToString(result2)
			//System.out.println("\n" + rString1 + "\n" + rString2)
		}
	}
}

