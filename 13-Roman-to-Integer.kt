class Solution {
    fun romanToInt(s: String): Int {
        val lastIndex = s.length - 1

        var result = 0
        val romanNumerals = s.map{ RomanDigit.of(it)}

        var current = 0
        var prev = 0
        for(i in lastIndex downTo 0) {
            current = romanNumerals[i].integerValue()
            if(prev > current) {
                current *= -1
            }
            result += current
            prev = current
        }
        return result
    }
}

data class RomanDigit private constructor(val char: Char) {
    fun realIntegerValue(next: RomanDigit): Int {
        val nowInt = integerValue()
        val nextInt = next.integerValue()
        if(nowInt >= nextInt) return nowInt
        return nowInt * -1
    }

    fun integerValue(): Int = symbolToIntegers[this] ?: error(\illelgal input\)

    companion object {
        val romanDigits = mapOf<Char, RomanDigit>(
            'I' to RomanDigit('I'),
            'V' to RomanDigit('V'),
            'X' to RomanDigit('X'),
            'L' to RomanDigit('L'),
            'C' to RomanDigit('C'),
            'D' to RomanDigit('D'),
            'M' to RomanDigit('M'),
        )

        fun of(char: Char): RomanDigit = romanDigits[char] ?: error(\illelgal input\)

        val symbolToIntegers = mapOf<RomanDigit, Int>(
            RomanDigit('I') to 1,
            RomanDigit('V') to 5,
            RomanDigit('X') to 10,
            RomanDigit('L') to 50,
            RomanDigit('C') to 100,
            RomanDigit('D') to 500,
            RomanDigit('M') to 1_000,
        )
    }
}

/*
2 -> II == 1+1
12 -> XII == 10 + 2
27 -> XXVII == 20 + 5 + 2

4 -> IV == -1 + 5
9 -> IX == -1 + 10

40 -> XL == -10 + 50 == 40
90 -> XC == -10 + 100 = 90

so we have to convert the Roman String to Integer.

What the key is the digit can present the positive value of negative value.

For example, VI is 5 + 1, so I is 1 here.
But IV is -1 + 5, so I is -1 here.

the character stands for negative value when the next charcter is bigger then current digit.

let's check this operation.
val i =  RomanDigit('I')
val v = RomanDigit('V')
val x = RomanDigit('X')

// iv -> i == -1
println(i.realIntegerValue(next = v)) // -1
println(v.realIntegerValue(next = i)) // 5

now all we have to do is just traverse the input string calculating the output.

 */