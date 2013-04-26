package operators

class RoboCrossover {
	
	def Random random = new Random()
	
	def crossover(i1, i2) {
		//System.out.println("Begin " + i1.evolvedProperties)
		for ( i in 0..6) {
			def result = []
			
			def arr1 = makeArray(i1.evolvedProperties[i])
			def arr2 = makeArray(i2.evolvedProperties[i])	
			//System.out.println("MakeArray  \n" + i1.evolvedProperties[i])
			
			result = onePointCrossover(arr1,arr2)
			//System.out.println("Result  \n" + result)
			
			i1.evolvedProperties[i] = backToString(result[0])
			//System.out.println("Final  \n" + i1.evolvedProperties[i])
		}	
		//System.out.println("End " + i1.evolvedProperties)
			return i1
		
	}
	
	def makeArray(str) {
		def codeArray = []
		codeArray = str.split("  ")
		return codeArray
	}
	//borrowed from Crossovers operator
	//currently 
	def onePointCrossover = { father, mother, crossoverPoint = random.nextInt(father.size()) ->
		[
			father[0..<crossoverPoint] + mother[crossoverPoint..<mother.size()]
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