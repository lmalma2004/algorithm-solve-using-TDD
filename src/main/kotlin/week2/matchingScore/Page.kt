package week2.matchingScore

data class Page(val html: String,
                val idx: Int = 0,
                var basicScore: Double = 0.0,
                var linkScore: Double = 0.0,
                var links: ArrayList<String> = arrayListOf(),
): Comparable<Page> {
    override fun compareTo(other: Page): Int {
        TODO("Not yet implemented")
    }

    companion object {
        fun create(s: String, idx: Int): Page {
            TODO("Not yet implemented")
        }
    }
}
