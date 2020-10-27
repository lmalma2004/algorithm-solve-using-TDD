package week2.matchingScore

data class Page(val html: String,
                val idx: Int = 0,
                var basicScore: Double = 0.0,
                var linkScore: Double = 0.0,
                var links: ArrayList<String> = arrayListOf(),
): Comparable<Page> {
    override fun compareTo(other: Page): Int {
        val matchPoint = basicScore + linkScore
        val otherMatchPoint = other.basicScore + other.linkScore

        return when {
            matchPoint > otherMatchPoint -> 1
            matchPoint < otherMatchPoint -> -1
            else -> idx - other.idx
        }
    }

    companion object {
        fun create(s: String, idx: Int): Page {
            return Page(s, idx)
        }
    }
}
