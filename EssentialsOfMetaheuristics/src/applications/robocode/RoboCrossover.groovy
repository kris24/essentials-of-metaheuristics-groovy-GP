package applications.robocode

class RoboCrossover {
	
	def Random random = new Random()
	
	def crossover(str1, str2) {
		def result = []
		
		def arr1 = makeArray(str1)
		def arr2 = makeArray(str2)	
		
		result = onePointCrossover(arr1,arr2)
		
		str1 = backToString(result[0])
		
		return str1
	}
	
	def makeArray(str) {
		def codeArray = []
		codeArray = str.split("  ")
		return codeArray
	}
	//borrowed from Crossovers operator
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