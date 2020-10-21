package week1.poppingBalloon

data class Balloon(
    val num: Int,
    var leftMin: Int,
    var rightMin: Int
) {

    companion object {
        fun create(num: Int): Balloon {
            if (num !in -1000000000..1000000000) {
                throw IllegalArgumentException()
            }

            return Balloon(num, 0, 0)
        }
    }
}
