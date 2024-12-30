class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val size = nums.size
        if (size == 1) return 1

        var uniqueIdx = 0
        var currentIdx = 0

        while (currentIdx < size) {
            if (currentIdx >= size) return uniqueIdx + 1

            if (nums[currentIdx] == nums[uniqueIdx]) {
                currentIdx++
                continue
            }
            uniqueIdx++
            nums[uniqueIdx] = nums[currentIdx]
            currentIdx++
        }
        return uniqueIdx + 1
    }
}
