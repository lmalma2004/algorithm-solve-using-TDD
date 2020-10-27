package week2.matchingScore

class MatchingScore {
    fun solution(word: String, pages: Array<String>): Int {
        val pagesManager = PagesManager.of(pages)
        pagesManager.calPagesScore(word)
        return pagesManager.getPageIdxOfMaxScore()
    }
}