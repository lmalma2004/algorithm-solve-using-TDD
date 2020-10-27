package week2.matchingScore

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class PageCalculatorTest {
    private val pageCalculator = PageCalculator.create()

    @Test
    fun `기본점수는 웹페이지에서 검색어가 등장한 횟수이다 (대소문자 무시)`() {
        val inputWord = "hi"

        val inputPage0 = Page.create("hi hi", 0)
        val inputPage1 = Page.create("hi hi hi", 1)
        val inputPage2 = Page.create("hi HI Hi hI", 2)

        val inputPages = TreeSet<Page>().apply {
            add(inputPage0)
            add(inputPage1)
            add(inputPage2)
        }

        val results = arrayOf(2, 3, 4)

        inputPages.forEach { pageCalculator.cal(inputPages, it, inputWord) }

        assertEquals(results[0], inputPage0.basicScore)
        assertEquals(results[1], inputPage1.basicScore)
        assertEquals(results[2], inputPage2.basicScore)
    }

    @Test
    fun `검색어는 단어 단위로 비교하며, 단어와 완전히 일치하는 경우에만 기본 점수에 반영한다`() {
        val inputWord = "hi"

        val inputPage0 = Page.create("hihi hi", 0)
        val inputPage1 = Page.create("hi hihihi hi", 1)
        val inputPage2 = Page.create("hi HI Hih hI", 2)

        val inputPages = TreeSet<Page>().apply {
            add(inputPage0)
            add(inputPage1)
            add(inputPage2)
        }

        val results = arrayOf(1, 2, 3)

        inputPages.forEach { pageCalculator.cal(inputPages, it, inputWord) }

        assertEquals(results[0], inputPage0.basicScore)
        assertEquals(results[1], inputPage1.basicScore)
        assertEquals(results[2], inputPage2.basicScore)
    }

    @Test
    fun `외부 링크수는 다른 웹페이지로 링크가 걸린 개수이다`() {
        val inputWord = "blind"

        val inputHtml0 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>"
        val inputHtml1 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>"
        val inputHtml2 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"

        val inputPage0 = Page.create(inputHtml0, 0)
        val inputPage1 = Page.create(inputHtml1, 1)
        val inputPage2 = Page.create(inputHtml2, 2)

        val inputPages = TreeSet<Page>().apply {
            add(inputPage0)
            add(inputPage1)
            add(inputPage2)
        }

        val results = arrayOf(1, 2, 1)

        inputPages.forEach { pageCalculator.cal(inputPages, it, inputWord) }

        assertEquals(results[0], inputPage0.basicScore)
        assertEquals(results[1], inputPage1.basicScore)
        assertEquals(results[2], inputPage2.basicScore)
    }

    @Test
    fun `링크점수는 해당 웹페이지로 링크가 걸린 다른 웹페이지의 기본점수 ÷ 외부 링크 수의 총합이다`() {
        val inputWord = "blind"

        val inputHtml0 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>"
        val inputHtml1 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>"
        val inputHtml2 = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"

        val inputPage0 = Page.create(inputHtml0, 0)
        val inputPage1 = Page.create(inputHtml1, 1)
        val inputPage2 = Page.create(inputHtml2, 2)

        val inputPages = TreeSet<Page>().apply {
            add(inputPage0)
            add(inputPage1)
            add(inputPage2)
        }

        val results = arrayOf(1.5, 3, 0.5)

        inputPages.forEach { pageCalculator.cal(inputPages, it, inputWord) }

        assertEquals(results[0], inputPage0.linkScore)
        assertEquals(results[1], inputPage1.linkScore)
        assertEquals(results[2], inputPage2.linkScore)
    }
}