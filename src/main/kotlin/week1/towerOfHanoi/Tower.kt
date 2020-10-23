package week1.towerOfHanoi

import java.util.*

data class Tower(var discs : Stack<Int>) {
    companion object {
        fun create(n: Int): Tower {
            if(n < 0) {
                throw IllegalArgumentException()
            }

            val discs = Stack<Int>()
            for(i in n downTo 1) {
                discs.push(i)
            }

            return Tower(discs)
        }
    }
}
