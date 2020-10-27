package week2.matchingScore

class MatchingScore {
    fun solution(word: String, pages: Array<String>): Int {
        val pagesManager = PagesManager.of(pages)
        pagesManager.calPageScore(word)
        return pagesManager.getPageIdxOfMaxScore()
    }
}