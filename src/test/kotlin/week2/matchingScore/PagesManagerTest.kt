package week2.matchingScore

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class PagesManagerTest {

    private val pagesManager = PagesManager.create()

    @Test
    fun `모든 웹페이지들의 점수를 계산해야 한다`() {
        val inputWord = "blind"

        val inputPage0 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>"
        val inputPage1 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>"
        val inputPage2 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"

        val inputPages = TreeSet<Page>()
        inputPages.add(Page.create(inputPage0, 0))
        inputPages.add(Page.create(inputPage1, 1))
        inputPages.add(Page.create(inputPage2, 2))

        val results = arrayOf(
                Page(inputPage0, 0, 3.0, 1.5, 1),
                Page(inputPage1, 1, 1.0, 3.0, 2),
                Page(inputPage2, 2, 1.0, 0.5, 1)
        )

        pagesManager.calPagesScore(inputPages, inputWord)

        assertArrayEquals(results, inputPages.toTypedArray())
    }

    @Test
    fun `매칭점수가 가장 높은 웹페이지가 여러개라면, 인덱스가 가장 낮은 웹페이지를 반환해야 한다`() {
        val inputPages = TreeSet<Page>()

        inputPages.add(Page("", 0, 3.0, 1.5, 1))
        assertEquals(0, pagesManager.getPageIdxOfMaxScore(inputPages))

        inputPages.add(Page("", 1, 3.0, 1.5, 1))
        assertEquals(0, pagesManager.getPageIdxOfMaxScore(inputPages))

        inputPages.add(Page("", 2, 4.0, 1.5, 1))
        assertEquals(2, pagesManager.getPageIdxOfMaxScore(inputPages))

        inputPages.add(Page("", 3, 4.0, 1.5, 1))
        assertEquals(2, pagesManager.getPageIdxOfMaxScore(inputPages))
    }
}








