package applications.robocode

class RoboCrossover {
	
	def Random random = new Random()
	
	def crossover(str1, str2) {
		def items = []
		
		System.out.println("Initial Strings")
		System.out.println(str1)
		//System.out.println(str2)
		
		def arr1 = makeArray(str1)
		def arr2 = makeArray(str2)
		
		System.out.println("Converted to Arrays")
		System.out.println(arr1)
		//System.out.println(arr2)		
		
		items = onePointCrossover(arr1,arr2)
		
		System.out.println("After Crossover")
		System.out.println(items[0])
		//System.out.println(items[1])
		
		str1 = backToString(items[0])
		str2 = backToString(items[1])
		
		System.out.println("Final Strings")
		System.out.println(str1)
		System.out.println(str2)
	}
	
	def makeArray(str) {
		def codeArray = []
		codeArray = str.split("  ")
		return codeArray
	}
	//borrowed from Crossovers operator
	def onePointCrossover = { father, mother, crossoverPoint = random.nextInt(father.size()) ->
		[
			father[0..<crossoverPoint] + mother[crossoverPoint..<mother.size()],
			mother[0..<crossoverPoint] + father[crossoverPoint..<father.size()]
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