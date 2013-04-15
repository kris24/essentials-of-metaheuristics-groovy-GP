package applications.robocode


import spock.lang.Specification

class TestRoboCrossover extends Specification {
    
	def roboCrossover
	
	def setup() {
		roboCrossover = new RoboCrossover()
	}


    def "Confirm that string split works"() {
		when: 
		def string1 = "setAhead(90); turnRight(360); setBack(180);"
		def result1 = roboCrossover.makeArray(string1)
		
		then:
		assert result1[0] == "setAhead(90);"
		assert result1[1] == "turnRight(360);"
		assert result1[2] == "setBack(180);"
		 

    }
}
