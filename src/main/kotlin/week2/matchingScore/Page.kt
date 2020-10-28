package week2.matchingScore

data class Page(val html: String,
                val idx: Int = 0,
                var basicScore: Double = 0.0,
                var linkScore: Double = 0.0,
                var links: ArrayList<String> = arrayListOf(),
) {
    companion object {
        fun create(s: String, idx: Int): Page {
            return Page(s, idx)
        }
    }
}
