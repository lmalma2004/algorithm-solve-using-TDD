package week1.quadCompression2

class QuadCompression2 {
    fun solution(arr: Array<IntArray>): IntArray {
        val area = Area.create(arr)
        return area.quadCompress(Point(0, 0), arr.size)
    }

    val seq = sequence {
        println("seq: I'll send 1")
        yield(1)

        println("seq: I'll send 2")
        yield(2)

        println("seq: I'll send 3")
        yield(3)
    }

    fun main() {
        for (i in seq) {
            println("main: I receive $i")
        }
    }
}