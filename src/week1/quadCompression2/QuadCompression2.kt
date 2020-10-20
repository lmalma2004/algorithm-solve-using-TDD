package week1.quadCompression2

class QuadCompression2 {
    fun solution(arr: Array<IntArray>): IntArray {
        val area = Area.create(arr)
        return area.quadCompress(Point(0, 0), arr.size)
    }
}