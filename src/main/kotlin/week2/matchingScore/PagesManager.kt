package week2.matchingScore

import java.util.*

class PagesManager private constructor() {

    fun calPagesScore(pages: SortedMap<String, Page>, word: String) {
        val pageCalculator = PageCalculator.create()

        pages.forEach {
            it.value.links = HtmlParser.findLinks(it.value.html)
        }

        pages.forEach {
            pageCalculator.calBasicScore(it.value, word)
        }

        pages.forEach {
            pageCalculator.calLinkScore(pages, it.key, word)
        }
    }

    fun getPageIdxOfMaxScore(pages: SortedMap<String, Page>): Int {
        pages.toSortedMap()
        return pages[pages.firstKey()]!!.idx
    }

    companion object {
        fun create(): PagesManager {
            return PagesManager()
        }
    }
}
