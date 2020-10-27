package week2.matchingScore

import java.util.*

class PagesManager private constructor() {
    fun calPagesScore(pages: SortedSet<Page>, word: String) {
        val pageCalculator = PageCalculator.create()
        pages.forEach {
            pageCalculator.cal(pages, it, word)
        }
    }

    fun getPageIdxOfMaxScore(pages: SortedSet<Page>): Int {
        pages.sorted()
        return pages.first().idx
    }

    companion object {
        fun create(): PagesManager {
            return PagesManager()
        }
    }
}
