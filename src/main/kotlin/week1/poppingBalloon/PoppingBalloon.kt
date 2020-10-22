package week1.poppingBalloon

class PoppingBalloon {
    fun solution(a: IntArray): Int {
        val balloons = createBalloons(a)
        return Popper(balloons).execute()
    }

    fun createBalloons(a: IntArray): Array<Balloon> {
        if (a.size != a.distinct().size) {
            throw IllegalArgumentException()
        }

        if (a.size !in 1..1000000) {
            throw IllegalArgumentException()
        }

        return a.map { Balloon.create(it) }.toTypedArray()
    }
}