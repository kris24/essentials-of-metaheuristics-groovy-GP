package operators

class RoboCrossover {
	
	def Random random = new Random()
	
	def crossover(problem, i1, i2) {
		def result = []
			result.add(onePointCrossover(p1,p2))
			
		def child = problem.copy(i1)
		child.evolvedProperties
		child.assignCode()
		child.assignVals()
		System.out.println("Original " + i1.values)
		System.out.println("New " + child.values)
		child.quality = problem.quality(child)
		System.out.println("Quality " + i1.quality + " " + child.quality)
			return child
		
	}
	//borrowed from Crossovers operator
	def onePointCrossover = { father, mother, crossoverPoint1 = random.nextInt(father.size()), crossoverPoint2 = random.nextInt(mother.size()) ->
		[
			father[0..<crossoverPoint1] + mother[crossoverPoint2..<mother.size()]
		]
	}
}