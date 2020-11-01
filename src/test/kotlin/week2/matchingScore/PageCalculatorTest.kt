package week2.matchingScore

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class PageCalculatorTest {
    private val pageCalculator = PageCalculator()

    @Test
    fun `the base score is the number of times a search term appears on a webpage, ignore single-case letters`() {
        val inputWord = "hi"

        val inputPage0 = Page.create("hi hi", 0)
        val inputPage1 = Page.create("hi hi hi", 1)
        val inputPage2 = Page.create("hi HI Hi hI", 2)

        val inputPages = HashMap<String, Page>().apply {
            put("p0", inputPage0)
            put("p1", inputPage1)
            put("p2", inputPage2)
        }

        val results = arrayOf(2, 3, 4)

        inputPages.forEach { pageCalculator.calBasicScore(it.value, inputWord) }

        assertEquals(results[0], inputPage0.basicScore.toInt())
        assertEquals(results[1], inputPage1.basicScore.toInt())
        assertEquals(results[2], inputPage2.basicScore.toInt())
    }

    @Test
    fun `search words are compared in terms of words and are reflected in the base score only if they are fully matched`() {
        val inputWord = "hi"

        val inputPage0 = Page.create("hihi hi", 0)
        val inputPage1 = Page.create("hi hihihi hi", 1)
        val inputPage2 = Page.create("hi HI Hih hI", 2)

        val inputPages = HashMap<String, Page>().apply {
            put("p0", inputPage0)
            put("p1", inputPage1)
            put("p2", inputPage2)
        }

        val results = arrayOf(1, 2, 3)

        inputPages.forEach { pageCalculator.calBasicScore(it.value, inputWord) }

        assertEquals(results[0], inputPage0.basicScore.toInt())
        assertEquals(results[1], inputPage1.basicScore.toInt())
        assertEquals(results[2], inputPage2.basicScore.toInt())
    }

    @Test
    fun `the link score is the sum of the base scores of other web pages linked to that webpage divided by the number of external links`() {
        val inputWord = "blind"

        val inputHtml0 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>"
        val inputHtml1 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>"
        val inputHtml2 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"

        val inputPage0 = Page.create(inputHtml0, 0)
        val inputPage1 = Page.create(inputHtml1, 1)
        val inputPage2 = Page.create(inputHtml2, 2)

        val inputPages = HashMap<String, Page>().apply {
            put("a.com", inputPage0)
            put("b.com", inputPage1)
            put("c.com", inputPage2)
        }

        val results = arrayOf(1.5, 3.0, 0.5)

        inputPages.forEach { it.value.links = HtmlParser.findLinks(it.value.html) }
        inputPages.forEach { pageCalculator.calBasicScore(it.value, inputWord) }
        inputPages.forEach { pageCalculator.calLinkScore(inputPages, it.key, inputWord) }

        assertEquals(results[0], inputPage0.linkScore)
        assertEquals(results[1], inputPage1.linkScore)
        assertEquals(results[2], inputPage2.linkScore)
    }
}