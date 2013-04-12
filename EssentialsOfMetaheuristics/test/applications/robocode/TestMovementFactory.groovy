package applications.robocode


import spock.lang.Specification

class TestMovementFactory extends Specification {
    
    def movementFactory


    def "Confirm that string is added to"() {
		when: true
		
		then:
		for ( i in 0..5 ) {
		movementFactory = new MovementFactory()
		System.out.println(movementFactory.returnRobot())
		}
		

    }
}
