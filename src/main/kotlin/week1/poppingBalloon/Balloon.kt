package week1.poppingBalloon

class Balloon(val arr: IntArray) {

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

    fun pop(): Int {
        val popper = Popper(this)
        return popper.execute()
    }
}
