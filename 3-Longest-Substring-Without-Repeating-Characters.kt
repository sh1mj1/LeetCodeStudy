class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val chars = mutableSetOf<Char>()
        var longestSubstringLength = 0
        var sIdx = 0
        var eIdx = 0

        while (s.length > eIdx) {
            if(chars.contains(s[eIdx])) {
                chars.remove(s[sIdx])
                sIdx++
            } else {
                chars.add(s[eIdx])
                eIdx++
                longestSubstringLength = max(chars.size, longestSubstringLength)
            }
        }
        return longestSubstringLength
    }
}
