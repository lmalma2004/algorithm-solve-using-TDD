package week1.quadCompression

class QuadCompression {
    fun solution(arr: Array<IntArray>): IntArray {
        return quadCompress(arr, Pair(0, 0), arr.size)
    }

    fun quadCompress(arr: Array<IntArray>, loc: Pair<Int, Int>, size: Int): IntArray {
        if(checkArea(arr, loc, size)) {
            if(arr[loc.first][loc.second] == 0)
                return intArrayOf(1, 0)
            return intArrayOf(0, 1)
        }

        val areas = divideArea(loc, size)
        val nextSize = size / 2
        val result = intArrayOf(0, 0)

        areas.forEach {
            var area = quadCompress(arr, it, nextSize)
            result[0] += area[0]
            result[1] += area[1]
        }

        return result
    }

    fun checkArea(area: Array<IntArray>, loc: Pair<Int, Int>, size: Int): Boolean {
        val num = area[loc.first][loc.second]

        for(r in loc.first until loc.first + size) {
            for(c in loc.second until loc.second + size) {
                if(num != area[r][c])
                    return false
            }
        }

        return true
    }

    fun divideArea(loc: Pair<Int, Int>, size: Int): Array<Pair<Int, Int>> {
        val loc1 = Pair(loc.first, loc.second)
        val loc2 = Pair(loc.first, loc.second + size / 2)
        val loc3 = Pair(loc.first + size / 2, loc.second)
        val loc4 = Pair(loc.first + size / 2, loc.second + size / 2)
        return arrayOf(loc1, loc2, loc3, loc4)
    }
}