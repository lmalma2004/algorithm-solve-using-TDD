package week1

class TriangleSnail {
    fun solution(n: Int): IntArray {
        val arrayList = createArrayList(n)
        fillNumInArrayList(arrayList)
        return getResult(arrayList)
    }

    fun createArrayList(n: Int): ArrayList<IntArray> {
        val emptyArrayList = arrayListOf<IntArray>()

        for (size in 1..n) {
            val intArray = IntArray(size)
            emptyArrayList.add(intArray)
        }

        return emptyArrayList
    }

    fun fillNumInArrayList(arrayList: ArrayList<IntArray>): ArrayList<IntArray> {
        fillNumFromOutsideToInside(arrayList, 0, 0, 1, "DOWN")
        return arrayList
    }

    fun getResult(fillArrayList: ArrayList<IntArray>): IntArray {
        return fillArrayList.flatMap { it.toList() }.toIntArray()
    }

    private fun fillNumFromOutsideToInside(arrayList: ArrayList<IntArray>, row: Int, col: Int, num: Int, direc: String) {
        if (!isRange(row, col, arrayList.size) || arrayList[row][col] != 0) {
            return
        }

        var nextRow = row
        var nextCol = col
        var nextNum = num

        when (direc) {
            "DOWN" -> {
                while (isRange(nextRow, nextCol, arrayList.size) && arrayList[nextRow][nextCol] == 0) {
                    arrayList[nextRow][nextCol] = nextNum
                    nextRow++
                    nextNum++
                }
                nextRow--
                nextCol++

                fillNumFromOutsideToInside(arrayList, nextRow, nextCol, nextNum, "RIGHT")
            }
            "RIGHT" -> {
                while (isRange(nextRow, nextCol, arrayList.size) && arrayList[nextRow][nextCol] == 0) {
                    arrayList[nextRow][nextCol] = nextNum
                    nextCol++
                    nextNum++
                }
                nextRow--
                nextCol -= 2

                fillNumFromOutsideToInside(arrayList, nextRow, nextCol, nextNum, "LEFT_UP")
            }
            "LEFT_UP" -> {
                while (isRange(nextRow, nextCol, arrayList.size) && arrayList[nextRow][nextCol] == 0) {
                    arrayList[nextRow][nextCol] = nextNum
                    nextRow--
                    nextCol--
                    nextNum++
                }
                nextRow += 2
                nextCol++

                fillNumFromOutsideToInside(arrayList, nextRow, nextCol, nextNum, "DOWN")
            }
        }
    }

    private fun isRange(row: Int, col: Int, size: Int): Boolean {
        if (row < 0 || col < 0)
            return false
        if (row >= size || col >= size)
            return false
        return true
    }
}