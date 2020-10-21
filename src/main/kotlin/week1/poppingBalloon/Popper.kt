package week1.poppingBalloon

class Popper(val balloon: Balloon) {
    companion object {
        fun of(balloon: Balloon): Popper {
            return Popper(balloon)
        }
    }

    fun execute(): Int {
        val balloonChecker = BalloonChecker()
        val checkedBalloon = balloonChecker.check(balloon)

        return balloonChecker.count(checkedBalloon)
    }
}
