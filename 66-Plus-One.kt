class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (index in digits.size - 1 downTo 0) {
            if (digits[index] < 9) {
                digits[index] += 1
                return digits
            }
            digits[index] = 0
        }
        return intArrayOf(1) + digits
    }
}