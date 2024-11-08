class Solution {
    fun climbStairs(n: Int): Int {
    if(n == 1) return 1
    if(n == 2) return 2

    val ways = IntArray(n) { 0 } 
    ways[0] = 1
    ways[1] = 2

    for(i in 2 until n) {
      ways[i] = ways[i-2] + ways[i-1]
    }

    return ways[n - 1] 
}
}