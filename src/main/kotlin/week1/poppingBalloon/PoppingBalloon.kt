package week1.poppingBalloon

class PoppingBalloon {
    fun solution(a: IntArray): Int {
        val balloons = createBalloons(a)
        return Popper(balloons).execute()
    }

    fun createBalloons(a: IntArray): Array<Balloon> {
        return a.map { Balloon.create(it) }.toTypedArray()
    }
}