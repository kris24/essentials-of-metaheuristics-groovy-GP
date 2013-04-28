package operators

class RoboCrossover {
	
	def Random random = new Random()
	
	def crossover(problem, i1, i2) {
		//System.out.println("Begin Crossover " + i1.evolvedProperties)
		def crossed = []
		for ( i in 0..6) {
			def result = []
			
			def arr1 = makeArray(i1.evolvedProperties[i])
			def arr2 = makeArray(i2.evolvedProperties[i])	
			//System.out.println("MakeArray  \n" + i1.evolvedProperties[i])
			
			result = onePointCrossover(arr1,arr2)
			//System.out.println("Result  \n" + result)
			
			crossed.add(backToString(result))
			//System.out.println("Final for " + i + " " + crossed)
		}
		//crossed = backToString(result)
		def child = problem.copy(i1)
		System.out.println("Crossed " + crossed)
		child.evolvedProperties = crossed
		child.assignCode()
		child.assignVals()
		System.out.println("Original " + i1.values)
		System.out.println("New " + child.values)
		child.quality = problem.quality(child)
		System.out.println("Quality " + i1.quality + " " + child.quality)
			return child
		
	}
	
	def makeArray(str) {
		def codeArray = []
		codeArray = str.split("  ")
		return codeArray
	}
	//borrowed from Crossovers operator
	def onePointCrossover = { father, mother, crossoverPoint1 = random.nextInt(father.size()), crossoverPoint2 = random.nextInt(mother.size()) ->
		[
			father[0..<crossoverPoint1] + mother[crossoverPoint2..<mother.size()]
		]
	}
	
	def backToString(array){
		def code = ""
		for ( item in array ) {
			code = code + item
		}
		return code
	}
}