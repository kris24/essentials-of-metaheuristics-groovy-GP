package problems

import spock.lang.Specification

class SinApproximationSpecification extends Specification {
    def sa = new SinApproximation()
    def 'test initialization'() {
        expect:
        
        sa.create()
        
        
    }
    
    def 'test quality'() {
        expect:
        def prob1 = sa.create()
        println(sa.quality(prob1))
        println(prob1)
        
    }
    
    
    
}