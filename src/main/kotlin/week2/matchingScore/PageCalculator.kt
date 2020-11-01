package week2.matchingScore

import java.util.*

class PageCalculator {

    fun calBasicScore(page: Page, word: String) {
        page.basicScore = HtmlParser.findWord(page.html, word)
    }

    fun calLinkScore(pages: HashMap<String, Page>, pageUrl: String, word: String) {
        var sum = 0.0

        pages.forEach {
            if (it.value.links.contains(pageUrl)) {
                sum += it.value.basicScore / it.value.links.size
            }
        }

        pages[pageUrl]!!.linkScore = sum
    }
}
