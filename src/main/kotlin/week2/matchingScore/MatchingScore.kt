package week2.matchingScore

import kotlin.collections.HashMap

class MatchingScore {

    fun solution(word: String, pages: Array<String>): Int {
        val mapOfPages = pagesToMap(pages)

        findLinks(mapOfPages)
        calPagesScore(mapOfPages, word)

        return getPageIdxOfMaxScore(mapOfPages)
    }

    private fun pagesToMap(pages: Array<String>): HashMap<String, Page> {
        val map = HashMap<String, Page>()

        pages.forEachIndexed { index, s ->
            val pageUrl = HtmlParser.findUrl(s)
            map[pageUrl] = Page.create(s, index)
        }

        return map
    }

    private fun findLinks(pages: HashMap<String, Page>) {
        pages.forEach {
            it.value.links = HtmlParser.findLinks(it.value.html)
        }
    }

    private fun calPagesScore(pages: HashMap<String, Page>, word: String) {
        PagesManager().calPagesScore(pages, word)
    }

    private fun getPageIdxOfMaxScore(pages: HashMap<String, Page>): Int {
        return PagesManager().getPageIdxOfMaxScore(pages)
    }
}