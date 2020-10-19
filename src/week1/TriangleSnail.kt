package week1

class TriangleSnail {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        return answer
    }

    fun createArrayList(n: Int): ArrayList<IntArray> {
        val result = arrayListOf<IntArray>()

        for(size in 1..n) {
            val intArray = IntArray(size)
            result.add(intArray)
        }

        return result
    }

    fun getResult(fillArrayList: java.util.ArrayList<IntArray>): IntArray {
        return intArrayOf()
    }

    fun fillArrayList(emptyArrayList: java.util.ArrayList<IntArray>): ArrayList<IntArray> {
        return arrayListOf()
    }
}