package week2.matchingScore

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class PagesManagerTest {

    private val pagesManager = PagesManager()

    @Test
    fun `have to calculate the scores of all the web pages`() {
        val inputWord = "blind"

        val inputPage0 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>"
        val inputPageUrl0 = HtmlParser.findUrl(inputPage0)

        val inputPage1 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>"
        val inputPageUrl1 = HtmlParser.findUrl(inputPage1)

        val inputPage2 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
        val inputPageUrl2 = HtmlParser.findUrl(inputPage2)

        val inputPages = HashMap<String, Page>()
        inputPages[inputPageUrl0] = Page.create(inputPage0, 0)
        inputPages[inputPageUrl1] = Page.create(inputPage1, 1)
        inputPages[inputPageUrl2] = Page.create(inputPage2, 2)

        inputPages.forEach {
            it.value.links = HtmlParser.findLinks(it.value.html)
        }
        pagesManager.calPagesScore(inputPages, inputWord)

        val results = arrayOf(
                Page(inputPage0, 0, 3.0, 1.5),
                Page(inputPage1, 1, 1.0, 3.0),
                Page(inputPage2, 2, 1.0, 0.5)
        )

        assertEquals(results[0].basicScore, inputPages[inputPageUrl0]!!.basicScore)
        assertEquals(results[0].linkScore, inputPages[inputPageUrl0]!!.linkScore)

        assertEquals(results[1].basicScore, inputPages[inputPageUrl1]!!.basicScore)
        assertEquals(results[1].linkScore, inputPages[inputPageUrl1]!!.linkScore)

        assertEquals(results[2].basicScore, inputPages[inputPageUrl2]!!.basicScore)
        assertEquals(results[2].linkScore, inputPages[inputPageUrl2]!!.linkScore)
    }

    @Test
    fun `if you have multiple Web pages with the highest matching score, you must return the lowest Web page in the index`() {
        val inputPages = HashMap<String, Page>()

        inputPages["page0"] = Page("page0", 0, 3.0, 1.5)
        assertEquals(0, pagesManager.getPageIdxOfMaxScore(inputPages))

        inputPages["page1"] = Page("page1", 1, 3.0, 1.5)
        assertEquals(0, pagesManager.getPageIdxOfMaxScore(inputPages))

        inputPages["page2"] = Page("page2", 2, 4.0, 1.5)
        assertEquals(2, pagesManager.getPageIdxOfMaxScore(inputPages))

        inputPages["page3"] = Page("page3", 3, 4.0, 1.5)
        assertEquals(2, pagesManager.getPageIdxOfMaxScore(inputPages))
    }
}








