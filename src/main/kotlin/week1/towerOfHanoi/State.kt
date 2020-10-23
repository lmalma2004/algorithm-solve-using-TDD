package week1.towerOfHanoi

class State(
        val towers: Array<Tower>,
        val path: ArrayList<IntArray> = arrayListOf()
) {
    fun isFinish(): Boolean {
        if(towers[0].discs.size == 0 && towers[1].discs.size == 0) {
            return true
        }
        return false
    }

    fun path(): Array<IntArray> {
        return path.toTypedArray()
    }

    companion object {
        fun of(towers: Array<Tower>): State {
            if(towers.size != 3) {
                throw IllegalArgumentException()
            }

            return State(towers)
        }
    }
}
