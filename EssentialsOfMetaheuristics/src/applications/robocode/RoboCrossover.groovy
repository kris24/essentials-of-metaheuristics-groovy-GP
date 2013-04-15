package applications.robocode

class RoboCrossover {
	def codeArray = []
	
	def makeArray(String code) {
		codeArray = code.split(" ")
		return codeArray
	}
}