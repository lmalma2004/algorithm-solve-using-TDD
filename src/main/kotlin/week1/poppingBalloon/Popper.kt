package week1.poppingBalloon

class Popper(private val balloons: Array<Balloon>) {
    companion object {
        fun of(balloons: Array<Balloon>): Popper {
            return Popper(balloons)
        }
    }

    fun execute(): Int {
        val balloonChecker = BalloonChecker()
        val checkedBalloons = balloonChecker.check(balloons)

        return balloonChecker.count(checkedBalloons)
    }
}
