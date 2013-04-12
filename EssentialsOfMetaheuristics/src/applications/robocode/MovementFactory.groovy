package applications.robocode

import java.util.Random

class MovementFactory {
	
	Random rand = new Random()
	def code = ""
	
	def orders = [" setAhead( /arg );", " setTurnRight( /arg );"]
	def args = [" getY()", " getX()"]
	def cons = [" 1000"]
	def comparators = []
	def functionSet = args + cons
	
	def limit = 4
	
	def returnRobot() {

		createOrders()
		
		return code
	}
	
	def createOrders() {
		for ( i in 0..rand.nextInt(limit)) {
			code = code + orders[rand.nextInt(orders.size)]
		}
	}
}