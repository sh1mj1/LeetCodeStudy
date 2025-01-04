class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val size = nums.size
        nums.sort()
        val results = mutableListOf<List<Int>>()

        for (a in 0 .. size - 4) {
            if (a > 0 && nums[a] == nums[a-1]) continue

            for (b in a + 1 .. size - 3) {
                if (b > a + 1 && nums[b] == nums[b-1]) continue
                
                var c = b + 1
                var d = size - 1

                while (c < d) {
                    val sum = nums[a].toLong() + nums[b].toLong() + nums[c].toLong() + nums[d].toLong()

                    when {
                        sum == target.toLong() -> {
                            val quadruplets = listOf(nums[a], nums[b], nums[c], nums[d])
                            results.add(quadruplets)

                            do {
                                d--
                            } while (c < d && nums[d] == nums[d+1])
                            do {
                                c++
                            } while (c < d && nums[c] == nums[c-1])   
                        }
                        sum > target.toLong() -> {
                            do {
                                d--
                            } while (c < d && nums[d] == nums[d+1])
                        }
                        sum < target.toLong() -> {
                            do {
                                c++
                            } while (c < d && nums[c] == nums[c-1])
                        }
                        else -> error(\\)
                    }
                }
            }
        }
        return results
    }
}
