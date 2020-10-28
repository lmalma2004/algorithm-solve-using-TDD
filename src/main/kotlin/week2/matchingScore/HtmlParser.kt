package week2.matchingScore

object HtmlParser {

    fun findUrl(html: String): String {
        var idx = html.indexOf("content=") + 17
        var url = ""

        while(html[idx] != '\"') {
            url += html[idx]
            idx++
        }

        return url
    }

    fun findWord(html: String, word: String): Double {
        val upperCaseHtml = html.toUpperCase()

        val regex = "([^A-Z])"
        val arr = upperCaseHtml.split(regex.toRegex())

        return arr.filter { it == word.toUpperCase() }.size.toDouble()
    }

    fun findLinks(html: String): ArrayList<String> {
        var idx = html.indexOf("a href=")
        val jumpSize = 16

        val links = arrayListOf<String>()
        while(idx != -1) {
            idx += jumpSize

            var link = ""
            while(html[idx] != '\"') {
                link += html[idx]
                idx++
            }
            links.add(link)

            idx = html.indexOf("a href=", idx)
        }

        return links
    }
}
