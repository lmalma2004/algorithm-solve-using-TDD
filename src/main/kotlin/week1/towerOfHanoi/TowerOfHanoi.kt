package week1.towerOfHanoi

class TowerOfHanoi {
    fun solution(n: Int): Array<IntArray> {
        val towers = createTowers(n)
        val solver = Solver.of(towers)
        return solver.execute()
    }

    private fun createTowers(n: Int): Array<Tower> {
        val arr = arrayOf(
                Tower.create(n),
                Tower.create(0),
                Tower.create(0)
        )

        return arr
    }
}