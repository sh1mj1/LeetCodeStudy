class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val numsSize = nums.size
        val result = mutableListOf<List<Int>>()
        val targetToLong = target.toLong()

        for (a in 0 until numsSize - 3) {
            if (a > 0 && nums[a] == nums[a - 1]) continue

            for (b in a + 1 until numsSize - 2) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue
                
                var c = b + 1
                var d = numsSize - 1

                while (c < d) {
                    val sum = nums[a].toLong() + nums[b].toLong() + nums[c].toLong() + nums[d].toLong()

                    when {
                        sum == targetToLong -> {
                            val quadruplets = listOf(nums[a], nums[b], nums[c], nums[d])
                            result.add(quadruplets)

                            do { c++ } while (c < d && nums[c] == nums[c - 1])
                            do { d-- } while (c < d && nums[d] == nums[d + 1])
                        }
                        sum < targetToLong -> do { c++ } while ( c < d && nums[c] == nums[c - 1])
                        sum > targetToLong -> do { d-- } while ( c < d && nums[d] == nums[d + 1])
                        else -> error(\sum: $sum target: $target\)
                    }
                } 
            }
        }

        return result
    }
}
