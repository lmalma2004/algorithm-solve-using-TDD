package week2.matchingScore

import kotlin.collections.HashMap

class MatchingScore {

    fun solution(word: String, pages: Array<String>): Int {
        val mapOfPages = pagesToMap(pages)

        val linksOfPages = findLinks(mapOfPages)

        mapOfPages.setLink(linksOfPages)

        return with(mapOfPages) {
            calPagesScore(this, word)
            getPageIdxOfMaxScore(this)
        }
    }

    private fun pagesToMap(pages: Array<String>): HashMap<String, Page> {
        val map = HashMap<String, Page>()

        pages.forEachIndexed { index, html ->
            val pageUrl = HtmlParser.findUrl(html)
            map[pageUrl] = Page.create(html, index)
        }

        return map
    }

    private fun findLinks(pages: HashMap<String, Page>): List<Pair<String, List<String>>> {
        return pages.map { Pair(it.key, HtmlParser.findLinks(it.value.html)) }
    }

    private fun calPagesScore(pages: HashMap<String, Page>, word: String) {
        PagesManager().calPagesScore(pages, word)
    }

    private fun getPageIdxOfMaxScore(pages: HashMap<String, Page>): Int {
        return PagesManager().getPageIdxOfMaxScore(pages)
    }
}

private fun HashMap<String, Page>.setLink(linksOfPages: List<Pair<String, List<String>>>) {
    linksOfPages.forEach {
        val page = it.first
        val links = it.second
        this[page]!!.links = links
    }
}