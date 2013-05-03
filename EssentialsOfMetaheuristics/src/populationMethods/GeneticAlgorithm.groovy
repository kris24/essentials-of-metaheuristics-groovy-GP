package populationMethods
import java.util.Random
import operators.RoboCrossover
import operators.TournamentSelection

class GeneticAlgorithm {
	// Algorithm 20
	
	// We need popsize to be global so that we can use it in the toString method, also added a default value
	def popsize = 17
	
	// Our Algorithm takes a Genetic Algorithm Problem, a desired population size
	def maximize(problem, populationSize=popsize, selector=new TournamentSelection(), crosser=new RoboCrossover()) {
		popsize = populationSize
	
		def startingPopulation = [] as Set
		
		for (i in 0..popsize-1) {
			def toAdd = problem.random()
			startingPopulation.add(toAdd) // Add a new random individual
		}
		startingPopulation.add(problem.seed())
		
		
		def best = problem.create()
		def qualityOfBest = problem.quality(best)
		while(!problem.terminate(best)) {
			for(individual in startingPopulation) {
				def newQuality = problem.quality(individual)
				System.out.println("Individual DarkSoul_" + individual.id + " score = " + individual.quality)
				if(newQuality > qualityOfBest) {
					best = individual
					qualityOfBest = newQuality
				}
							
			}

			def endingPopulation = [] as Set
			
			for(i in 0..(popsize/2)) {
				System.out.println("\n + BEST SCORE:  DarkSoul_" + best.id + " Q= " + best.quality)
				def parents = selector.select(problem, startingPopulation as List)
				//System.out.println(" ParentA    "  + parentA.id)
				//System.out.println(" ParentB    "  + parentB.id)
				def children = []
				children[0] = crosser.crossover(problem, parents[0], parents[1])
				children[1] = crosser.crossover(problem, parents[1], parents[0])
				//System.out.println("New robot = DarkSoul_" + children[0].id)
				//System.out.println("New robot = DarkSoul_" + children[1].id)
				
				endingPopulation.add(children[0])
				endingPopulation.add(children[1])
				
			}
			
			startingPopulation = endingPopulation
		}
		return best
	}
	
	String toString() {
		"GA_" + popsize
	}

}
