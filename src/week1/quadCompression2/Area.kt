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
        return intArrayOf()
    }
}