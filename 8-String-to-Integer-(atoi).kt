class Solution {
    fun myAtoi(s: String): Int {
        var result = 0
        var isPositive = true
        var isSigned = false
        val firstDigitInIntegerMax = Int.MAX_VALUE % 10
        var digitWasRead = false
        var isLeadingBlank = true

        s.forEachIndexed { idx, char ->
            if(isLeadingBlank && char == ' ') return@forEachIndexed
            isLeadingBlank = false
            
            if (!digitWasRead && (char == '+' || char == '-')) {
                if (isSigned) return 0
                if (char == '-') isPositive = false
                isSigned = true
                return@forEachIndexed
            }
            if (!digitWasRead && char !in '0' .. '9' ) return 0
            if (digitWasRead && char !in '0' .. '9') return resultWithSign(result, isPositive)
            if(char in '0' .. '9') {
                digitWasRead = true
                val currentInt = char.digitToInt()
                if (isPositive) {
                    if (result > Int.MAX_VALUE / 10) return Int.MAX_VALUE
                    if (result == Int.MAX_VALUE / 10 && currentInt > firstDigitInIntegerMax) return Int.MAX_VALUE
                }
                if (!isPositive) {
                    if (result > Int.MAX_VALUE / 10) return Int.MIN_VALUE
                    if (result == Int.MAX_VALUE / 10 && currentInt > firstDigitInIntegerMax + 1 ) return Int.MIN_VALUE
                }
                if(isSigned) {
                    if(result > result * 10 + currentInt) {
                        if (isPositive) return Int.MAX_VALUE
                        return Int.MIN_VALUE
                    }
                }
                result = result * 10 + currentInt
            }
            
        }        
        return resultWithSign(result, isPositive)
    }

    private fun resultWithSign(result: Int, isPositive: Boolean): Int {
        if(isPositive) {
            return result
        }
        return result * -1
    }
}
