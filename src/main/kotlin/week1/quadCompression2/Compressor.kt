package week1.quadCompression2

class Compressor(val area: Array<IntArray>) {
    companion object {
        fun create(area: Array<IntArray>): Compressor {
            return Compressor(area)
        }
    }

    fun canCompress(startPoint: Point, areaSize: Int): Boolean {
        var row = startPoint.row
        var col = startPoint.col

        val num = area[row][col]

        for (r in row until row + areaSize) {
            for (c in col until col + areaSize) {
                if (area[r][c] != num)
                    return false
            }
        }

        return true
    }

    fun compress(startPoint: Point): IntArray {
        return when (area[startPoint.row][startPoint.col]) {
            0 -> intArrayOf(1, 0)
            1 -> intArrayOf(0, 1)
            else -> throw IllegalArgumentException()
        }
    }

}
