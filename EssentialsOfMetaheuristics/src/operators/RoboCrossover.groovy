package operators

class RoboCrossover {
	
	def Random random = new Random()
	
	def crossover(problem, i1, i2) {
		def result
			result = onePointCrossover(i1.evolvedProperties,i2.evolvedProperties)
		
			
		def child = problem.copy(i1)
		//System.out.println("Original Father " + i1.evolvedProperties)
		//System.out.println("result " + result)
		child.evolvedProperties = result		
		//System.out.println("Crossover Result " + child.evolvedProperties)
		child.quality = problem.quality(child)
		System.out.println("Quality of Child " + i1.quality + " " + child.quality)
			return child
		
	}
	//borrowed from Crossovers operator
	def onePointCrossover = { father, mother, crossoverPoint1 = 0, 
		crossoverPoint2 = random.nextInt(3) ->
		crossoverPoint1 += crossoverPoint2 + 3
		[
			def res = father[0..<crossoverPoint1] + mother[crossoverPoint2..<mother.size()]			
		]
		System.out.println("STUFFS " + res)
		return res
	}
}