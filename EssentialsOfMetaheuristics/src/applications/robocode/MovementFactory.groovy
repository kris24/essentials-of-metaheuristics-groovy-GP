package applications.robocode

import java.util.Random
import java.util.regex.Pattern

class MovementFactory {
	
	Random rand = new Random()
	def code = ""
	def Pattern arg = Pattern.compile("/arg")
	def Pattern ord = Pattern.compile("/ord")
	def Pattern com = Pattern.compile("/com")
	
	def orders = 
	[" setAhead(/arg); \n",
	" setBack(/arg); \n", 
	" setTurnRight(/arg); \n", 
	" setTurnLeft(/arg); \n",
	" if (/arg/com/arg) {\n/ord} \n",
	" move =/arg ; \n",
	" ahead(/arg); \n",
	" back(/arg); \n",
	" stop(); \n",
	" turnRight(/arg); \n", 
	" turnLeft(/arg); \n"]
	
	def args = 
	[" getY()", 
	" getX()",
	" getVelocity()",
	" getEnergy()",
	" getHeading()",
	" getGunHeading()",
	" move"]
	def cons = [" 1000"," 360", " 90", " 180", " -1"]
	def comparators = [" ==", " <", " >" ]
	def functionSet = args + cons
	
	def limit = 6
	
	def returnRobot() {

		create()
		fillOrders()
		fillArgs()
		fillCom()
		
		return code
	}
	
	def create() {
		for ( i in 0..rand.nextInt(limit)) {
			code = code + orders[rand.nextInt(orders.size)]
		}
	}
	
	def fillOrders() {
		if (code.find(ord)) {
			code = code.replaceFirst(ord, orders[rand.nextInt(orders.size)])
			fillOrders()
		}
	}
	
	def fillArgs() {
		if (code.find(arg)) {
			code = code.replaceFirst(arg, functionSet[rand.nextInt(functionSet.size)])
			fillArgs()
		}
	}
	
	def fillCom() {
		if (code.find(com)) {
			code = code.replaceFirst(com, comparators[rand.nextInt(comparators.size)])
			fillCom()
		}
	}
	
}