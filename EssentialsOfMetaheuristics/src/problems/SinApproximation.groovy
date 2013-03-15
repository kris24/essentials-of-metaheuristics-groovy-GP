package problems

class SinApproximation {





    def testPoints = 100
    def sinPoints = []

    def create = {
        for (double i = 0; i < Math.PI*2; i += Math.PI*2/testPoints) {
            sinPoints.add(Math.sin(i))
            //println(Math.sin(i))
        }

        return true
    }

    def quality = {


    }


}