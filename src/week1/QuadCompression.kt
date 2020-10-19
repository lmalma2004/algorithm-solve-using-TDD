package week1

class QuadCompression {
    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        return answer
    }

    fun checkArea(area: Array<IntArray>): Boolean {
        return area.all {
            it.contains(1) != it.contains(0)
        }
    }

    fun compressArea(area: Array<IntArray>): Int {
        if(area.all { it.contains(1) })
            return 1
        return 0
    }

    fun divideArea(loc: Pair<Int, Int>, size: Int): Array<Pair<Int, Int>> {
        val loc1 = Pair(loc.first, loc.second)
        val loc2 = Pair(loc.first, loc.second + size / 2)
        val loc3 = Pair(loc.first + size / 2, loc.second)
        val loc4 = Pair(loc.first + size / 2, loc.second + size / 2)
        return arrayOf(loc1, loc2, loc3, loc4)
    }
}