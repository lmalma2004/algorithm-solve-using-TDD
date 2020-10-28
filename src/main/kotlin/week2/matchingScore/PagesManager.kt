package week2.matchingScore

import java.util.*
import kotlin.Comparator

class PagesManager {

    fun calPagesScore(pages: HashMap<String, Page>, word: String) {
        val pageCalculator = PageCalculator()

        pages.forEach {
            pageCalculator.calBasicScore(it.value, word)
        }

        pages.forEach {
            pageCalculator.calLinkScore(pages, it.key, word)
        }
    }

    fun getPageIdxOfMaxScore(pages: HashMap<String, Page>): Int {
        return with(pages.toList()) {
            Collections.sort(this, PageComparator())
            this.first().second.idx
        }
    }

    class PageComparator : Comparator<Pair<String, Page>> {
        override fun compare(o1: Pair<String, Page>, o2: Pair<String, Page>): Int {
            val o1matchPoint = o1.second.basicScore + o1.second.linkScore
            val o2MatchPoint = o2.second.basicScore + o2.second.linkScore

            return when {
                o1matchPoint > o2MatchPoint -> -1
                o1matchPoint < o2MatchPoint -> 1
                else -> o1.second.idx - o2.second.idx
            }
        }
    }
}
