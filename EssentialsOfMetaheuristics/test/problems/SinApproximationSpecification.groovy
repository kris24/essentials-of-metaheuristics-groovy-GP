package problems

import spock.lang.Specification

class SinApproximationSpecification extends Specification {
    def sa = new SinApproximation()
    def 'test initialization'() {
        expect:
        
        sa.create()
        
        
    }
    
}