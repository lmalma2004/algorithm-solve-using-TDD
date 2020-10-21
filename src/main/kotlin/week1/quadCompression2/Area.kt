package week1.quadCompression2

class Area {
    companion object {
        fun create(arr: Array<IntArray>): Area {
            // 2의 제곱크기의 배열인가
            if ((arr.size and (arr.size - 1)) != 0) {
                throw IllegalArgumentException()
            }
            // 정사각형 모양인가
            if (!arr.all { arr.size == it.size }) {
                throw IllegalArgumentException()
            }

            val instance = Area()
            instance.area = arr
            return instance
        }
    }

    private lateinit var area: Array<IntArray>

    fun quadCompress(startPoint: Point, areaSize: Int): IntArray {
        val compressor = Compressor(area)

        if (compressor.canCompress(startPoint, areaSize)) {
            return compressor.compress(startPoint)
        }

        val divider = Divider()
        val dividedAreaPoints = divider.divide(startPoint, areaSize)
        val dividedAreaSize = divider.nextSize(areaSize)

        var compressedArea = intArrayOf(0, 0)

        dividedAreaPoints.forEach {
            val partialCompressedArea = quadCompress(it, dividedAreaSize)
            compressedArea = compressedArea.mapIndexed { i, value -> value + partialCompressedArea[i] }.toIntArray()
        }

        return compressedArea
    }
}