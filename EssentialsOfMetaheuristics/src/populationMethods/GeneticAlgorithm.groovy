package populationMethods
import java.util.Random
import operators.RoboCrossover
import operators.TournamentSelection

class GeneticAlgorithm {
	// Algorithm 20
	
	// We need popsize to be global so that we can use it in the toString method, also added a default value
	def popsize = 8
	
	// Our Algorithm takes a Genetic Algorithm Problem, a desired population size
	def maximize(problem, populationSize=popsize, selector=new TournamentSelection(), crosser=new RoboCrossover()) {
		popsize = populationSize
	
		def startingPopulation = [] as Set
		
		popsize.times {
			def toAdd = problem.random()
			startingPopulation.add(toAdd) // Add a new random individual
			//System.out.println(toAdd.evolvedProperties)
		}
		
		def best = problem.create()
		def qualityOfBest = problem.quality(best)
		while(!problem.terminate(best)) {
			for(individual in startingPopulation) {
				def newQuality = problem.quality(individual)
				if(newQuality > qualityOfBest) {
					best = individual
					qualityOfBest = newQuality
				}
				
			}

			def endingPopulation = [] as Set
			
			for(i in 0..(popsize/2)) {
				def parentA = selector.select(problem, startingPopulation as List)
				def parentB = selector.select(problem, startingPopulation as List)
				System.out.println(" ParentA    "  + parentA.id)
				System.out.println(" ParentB    "  + parentB.id)
				def children = []
				children[0] = crosser.crossover(parentA, parentB)
				children[1] = crosser.crossover(parentB, parentA)
				System.out.println("New robot = DarkSoul_" + children[0].id + " " + children[0].quality)
				System.out.println("New robot = DarkSoul_" + children[1].id + " " + children[1].quality)
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
