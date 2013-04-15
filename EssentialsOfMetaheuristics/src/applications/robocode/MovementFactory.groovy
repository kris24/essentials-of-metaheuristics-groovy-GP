package applications.robocode

import java.util.Random
import java.util.regex.Pattern

class MovementFactory {
	
	Random rand = new Random()
	def code = ""
	def Pattern arg = Pattern.compile("/arg")
	def Pattern ord = Pattern.compile("/ord")
	def Pattern com = Pattern.compile("/com")
	//no spaces except after semicolon
	def orders = 
	[" setAhead(/arg); ",
	" setBack(/arg); ", 
	" setTurnRight(/arg); ", 
	" setTurnLeft(/arg); ",
	" if(/arg/com/arg){/ord} ",
	" move=/arg ; ",
	" ahead(/arg); ",
	" back(/arg); ",
	" stop(); ",
	" turnRight(/arg); ", 
	" turnLeft(/arg); "]
	
	def args = 
	["getY()", 
	"getX()",
	"getVelocity()",
	"getEnergy()",
	"getHeading()",
	"getGunHeading()",
	"move"]
	def cons = ["1000","360", "90", "180", "-1"]
	def comparators = ["==", "<", ">" ]
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