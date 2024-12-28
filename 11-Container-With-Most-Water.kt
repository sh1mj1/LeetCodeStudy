class Solution {
    fun maxArea(height: IntArray): Int {
        val heightSize = height.size
        
        var startIdx = 0
        var endIdx = heightSize - 1
        var maxWater = 0

        while(startIdx < endIdx) {
            val startHeight = height[startIdx]
            val endHeight = height[endIdx]
            val width = endIdx - startIdx

            if (startHeight >= endHeight) {
                maxWater = max(maxWater, width * endHeight)
                endIdx--
                continue
            }
            maxWater = max(maxWater, width * startHeight)
            startIdx++
        }
        return maxWater
    }
}
