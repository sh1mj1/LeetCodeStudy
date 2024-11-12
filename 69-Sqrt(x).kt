import kotlin.math.*

class Solution {
    fun mySqrt(x: Int): Int {
        var start = 0
        val possibleMaxEnd = 65536
        var end = min(x, possibleMaxEnd)

        while( start <= end  ) {
            var middle = (start + end) / 2
            val square = middle * middle
            when {
                (square == x) -> return middle
                (square > x) -> end = middle - 1
                (square < x) -> start = middle + 1
                else -> error(\You cannot reach this line\)
            }
        }
        return middle
    }
}

/*
1, 2, 3, 4, ... (2^31) -1




 */