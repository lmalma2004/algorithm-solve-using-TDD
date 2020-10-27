package week2.matchingScore

import java.util.*

class PageCalculator private constructor() {

    fun calBasicScore(page: Page, word: String) {
        page.basicScore = HtmlParser.findWord(page.html, word)
    }

    fun calLinkScore(pages: SortedMap<String, Page>, pageUrl: String, word: String) {
        var sum = 0.0

        pages[pageUrl]!!.links.forEach {
            val page = pages[it]!!
            sum += (page.basicScore / page.links.size)
        }

        pages[pageUrl]!!.linkScore = sum
    }

    companion object {
        fun create(): PageCalculator {
            return PageCalculator()
        }
    }
}
