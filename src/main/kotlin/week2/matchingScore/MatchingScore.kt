package week2.matchingScore

import java.util.*

class MatchingScore {
    fun solution(word: String, pages: Array<String>): Int {
        val mapOfPages = TreeMap<Page, Boolean>()

        pages.forEachIndexed { index, s ->
            mapOfPages[Page.create(s, index)] = true
        }

        val pagesManager = PagesManager.create()
        pagesManager.calPagesScore(mapOfPages, word)
        return pagesManager.getPageIdxOfMaxScore(mapOfPages)
    }
}