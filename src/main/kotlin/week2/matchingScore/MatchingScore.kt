package week2.matchingScore

import java.util.*

class MatchingScore {
    fun solution(word: String, pages: Array<String>): Int {
        val mapOfPages = TreeSet<Page>()

        pages.forEachIndexed { index, s ->
            mapOfPages.add(Page.create(s, index))
        }

        val pagesManager = PagesManager.create()
        pagesManager.calPagesScore(mapOfPages, word)
        return pagesManager.getPageIdxOfMaxScore(mapOfPages)
    }
}