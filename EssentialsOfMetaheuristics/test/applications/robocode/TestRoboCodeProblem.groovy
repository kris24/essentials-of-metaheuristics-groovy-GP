package applications.robocode

import problems.RobocodeProblem
import spock.lang.Specification

class TestRoboCodeProblem extends Specification {

	def "make an individual"() {
		when:
		def robo = new RobocodeProblem()
		robo.create()
		
		then:		
		System.out.println(robo.individual.evolvedProperties)
		System.out.println(robo.individual.id)
		System.out.println(robo.individual.evolvedProperties.toString())
	}

	
	
	

}
