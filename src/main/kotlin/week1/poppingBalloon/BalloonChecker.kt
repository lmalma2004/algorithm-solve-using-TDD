package week1.poppingBalloon

class BalloonChecker {
    fun check(balloons: Array<Balloon>): Array<Balloon> {
        leftCheck(balloons)
        rightCheck(balloons)
        return balloons
    }

    fun count(checkedBalloon: Array<Balloon>): Int {
        return checkedBalloon.count { (it.num < it.leftMin) or (it.num < it.rightMin) }
    }

    private fun leftCheck(balloons: Array<Balloon>) {
        balloons.first().leftMin = balloons.first().num + 1

        var currMin = balloons.first().num
        for (i in 1 until balloons.size) {
            balloons[i].leftMin = currMin
            if (currMin > balloons[i].num) {
                currMin = balloons[i].num
            }
        }
    }

    private fun rightCheck(balloons: Array<Balloon>) {
        balloons.last().rightMin = balloons.last().num + 1

        var currMin = balloons.last().num
        for (i in balloons.size - 2 downTo 0 step 1) {
            balloons[i].rightMin = currMin
            if (currMin > balloons[i].num) {
                currMin = balloons[i].num
            }
        }
    }
}
