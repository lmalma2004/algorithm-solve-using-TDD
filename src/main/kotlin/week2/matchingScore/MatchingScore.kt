package week2.matchingScore

import java.util.*

class MatchingScore {
    fun solution(word: String, pages: Array<String>): Int {
        val mapOfPages = TreeMap<String, Page>()

        pages.forEachIndexed { index, s ->
            val pageUrl = HtmlParser.findUrl(s)
            mapOfPages[pageUrl] = Page.create(s, index)
        }

        val pagesManager = PagesManager.create()
        pagesManager.calPagesScore(mapOfPages, word)

        return pagesManager.getPageIdxOfMaxScore(mapOfPages)
    }
}