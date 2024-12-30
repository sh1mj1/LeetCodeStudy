class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        val size = nums.size

        var ans = nums[0] + nums[1] + nums[2]

        for (stand in 0 until size - 1) {
            var start = stand + 1
            var end = size - 1

            while (start < end) {
                val currentSum = nums[stand] + nums[start] + nums[end]

                if (abs(currentSum - target) < abs(ans - target)) {
                    ans = currentSum
                }

                when {
                    currentSum < target -> start++
                    currentSum > target -> end--
                    else -> return currentSum
                }
            }
        }
        return ans
    }
}
