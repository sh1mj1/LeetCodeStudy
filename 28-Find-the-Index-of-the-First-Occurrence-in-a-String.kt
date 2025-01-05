class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val needleLength = needle.length

        haystackLoop@ for (i in 0 .. haystack.length - needleLength) {
            if (haystack[i] != needle[0]) continue

            for (j in 1 until needleLength) {
                if (haystack[j + i] != needle[j]) continue@haystackLoop
            }
            return i
        }
        return -1
    }
}
