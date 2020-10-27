package week2.matchingScore

import java.util.*

class PagesManager private constructor() {
    fun calPagesScore(pages: SortedMap<Page, Boolean>, word: String) {
        val pageCalculator = PageCalculator.create()
        val htmlParser = HtmlParser.create()

        pages.forEach {
            htmlParser.findLinks(it)
        }

        pages.forEach {
            pageCalculator.calBasicScore(it.key, word)
        }

        pages.forEach {
            pageCalculator.calLinkScore(pages, it.key, word)
        }
    }

    fun getPageIdxOfMaxScore(pages: SortedMap<Page, Boolean>): Int {
        pages.toSortedMap()
        return pages.firstKey().idx
    }

    companion object {
        fun create(): PagesManager {
            return PagesManager()
        }
    }
}
