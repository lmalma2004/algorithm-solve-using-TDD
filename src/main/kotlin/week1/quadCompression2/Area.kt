package week1.quadCompression2

class Area {
    companion object {
        fun create(arr: Array<IntArray>): Area {
            val instance = Area()
            instance.area = arr
            return instance
        }
    }

    private lateinit var area: Array<IntArray>

    fun quadCompress(startPoint: Point, areaSize: Int): IntArray {
        val compressor = Compressor(area)

        if(compressor.canCompress(startPoint, areaSize)) {
            return compressor.compress(startPoint)
        }

        val divider = Divider()
        val dividedAreaPoints = divider.divide(startPoint, areaSize)
        val dividedAreaSize = divider.nextSize(areaSize)

        val compressedArea = intArrayOf(0, 0)

        dividedAreaPoints.forEach {
            val partialCompressedArea = quadCompress(it, dividedAreaSize)
            compressedArea.mapIndexed { i, value -> value + partialCompressedArea[i] }
        }

        return compressedArea
    }
}