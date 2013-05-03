package operators

import groovy.transform.ToString
import java.util.Random

class TournamentSelection{
    Integer tournamentSize = 5
    Random r = new Random()
    def select(problem, population){
        def s = population[r.nextInt(population.size())]
		//System.out.println("population size "+ population.size())
        def sQuality = problem.quality(s)
		System.out.println("Tournament Pick DarkSoul_" + s.id + " " + sQuality)
        for(i in 2..tournamentSize) {
            def n = population[r.nextInt(population.size())]
            def nQuality = problem.quality(n)
			System.out.println("Tournament Pick DarkSoul_" + n.id + " " + nQuality)
            if(nQuality > sQuality){
                s = n
                sQuality = nQuality
            }
        }
		System.out.println("Tournament Pick result DarkSoul_ " + s.id + " " + sQuality)
        return s
    }
    String toString() {
        "TS_" + tournamentSize
    }
}