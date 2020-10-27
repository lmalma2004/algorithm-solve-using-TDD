package week2.matchingScore

data class Page(val url: String,
                val idx: Int,
                var basicScore: Int = 0,
                var matchScore: Int = 0,
                var linkCnt: Int = 0,
) {
    companion object {
        fun create(idx: Int, s: String): Page {
            TODO("Not yet implemented")
        }
    }
}
