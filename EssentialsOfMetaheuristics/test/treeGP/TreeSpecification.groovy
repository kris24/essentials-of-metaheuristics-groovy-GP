package treeGP

import spock.lang.Specification

class TreeSpecification extends Specification {
	def 'test create Tree'() {
		when:
		test.growTree(0)


		then:
		true
	}
}