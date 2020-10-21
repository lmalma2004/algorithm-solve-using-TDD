package week1.poppingBalloon

data class Balloon(val arr: IntArray) {

    companion object {
        fun create(arr: IntArray): Balloon {
            if (arr.size !in 1..1000000) {
                throw IllegalArgumentException()
            }

            if (arr.distinct().size != arr.size) {
                throw IllegalArgumentException()
            }

            if (!arr.all { it in -1000000000..1000000000 }) {
                throw IllegalArgumentException()
            }

            return Balloon(arr)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Balloon

        if (!arr.contentEquals(other.arr)) return false

        return true
    }

    override fun hashCode(): Int {
        return arr.contentHashCode()
    }
}
