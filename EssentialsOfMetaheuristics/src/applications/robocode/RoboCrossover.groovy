package applications.robocode

class RoboCrossover {
	def codeArray = []
	def crossoverArray = []
	def Random random = new Random()
	def code = ""
	
	def makeArray(code) {
		codeArray = code.split("  ")
		return codeArray
	}
	//borrowed from Crossovers operator
	def onePointCrossover = { father, mother, crossoverPoint = random.nextInt(father.size()) ->
		[
			crossoverArray.add(father[0..<crossoverPoint] + mother[crossoverPoint..<mother.size()]),
			crossoverArray.add(mother[0..<crossoverPoint] + father[crossoverPoint..<father.size()])
		]
		return crossoverArray
	}
	
	def backToString(array){
		for ( item in array ) {
			code = code + item
		}
		return code
	}
}