class Solution {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE) return 0

        var result = 0
        var current = if (x < 0) -x else x
        val isNegative = x < 0

        while (current > 0) {
            val digit = current % 10
            current /= 10

            if (result > (Int.MAX_VALUE - digit) / 10) {
                return 0
            }

            result = result * 10 + digit
        }

        return if (isNegative) -result else result
    }
}
