package operators

import groovy.transform.ToString
import java.util.Random

class TournamentSelection{
    Integer tournamentSize = 10
    Random r = new Random()
	def result = []
    def select(problem, population){
        def best = population[r.nextInt(population.size())]
        def bestQuality = problem.quality(best)
		def second = population[r.nextInt(population.size())]
		def secondQuality = problem.quality(second)
        for(i in 2..tournamentSize) {
            def n = population[r.nextInt(population.size())]
            def nQuality = problem.quality(n)
            if(nQuality >= bestQuality){
				best = n
                bestQuality = nQuality
            }
			else if(nQuality > secondQuality){
				second = n
				secondQuality = nQuality
			}
			result[0] = best
			result[1] = second
        }
		System.out.println("Tournament Pick1 DarkSoul_ " + best.id + " " + bestQuality)
		System.out.println("Tournament Pick2 DarkSoul_ " + second.id + " " + secondQuality)
        return result
    }
    String toString() {
        "TS_" + tournamentSize
    }
}