package week1.poppingBalloon

class PoppingBalloon {
    fun solution(a: IntArray): Int {
        val balloon = Balloon.create(a)
        return balloon.pop()
    }
}