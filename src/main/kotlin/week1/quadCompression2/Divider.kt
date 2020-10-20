package week1.quadCompression2

class Divider {
    fun divide(startPoint: Point, areaSize: Int): ArrayList<Point> {
        val row = startPoint.row
        val col = startPoint.col
        val nextSize = nextSize(areaSize)

        return arrayListOf(
            Point(row, col),
            Point(row, col + nextSize),
            Point(row + nextSize, col),
            Point(row + nextSize, col + nextSize)
        )
    }

    fun nextSize(areaSize: Int): Int {
        return areaSize / 2
    }

}
