package week2.matchingScore

object HtmlParser {

    fun findUrl(html: String): String {
        var idx = html.indexOf("<meta property=\"og:url\" content=") + 41
        return findLink(html, idx)
    }

    fun findWord(html: String, word: String): Double {
        val upperCaseHtml = html.toUpperCase()

        val regex = "([^A-Z])"
        val splitWords = upperCaseHtml.split(regex.toRegex())

        return splitWords.filter { it == word.toUpperCase() }.size.toDouble()
    }

    fun findLinks(html: String): ArrayList<String> {
        var idx = html.indexOf("a href=")
        val jumpSize = 16

        val links = arrayListOf<String>()
        while (idx != -1) {
            idx += jumpSize

            val link = findLink(html, idx)
            links.add(link)

            idx = html.indexOf("a href=", idx)
        }

        return links
    }

    private fun findLink(s: String, startIdx: Int): String {
        var idx = startIdx
        var link = ""
        while (s[idx] != '\"') {
            link += s[idx]
            idx++
        }
        return link
    }
}
