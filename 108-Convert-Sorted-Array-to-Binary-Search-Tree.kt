/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return RecursiveSolution.sortedArrayToBST(nums)
        // return IterativeSolution.sortedArrayToBST(nums)
        // return MyFirstSolution.sortedArrayToBST(nums)
    } 
}

object RecursiveSolution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun createdTree(left: Int, right: Int) : TreeNode? {
            if (left > right) return null
            val midIdx = (left + right) / 2
            val root = TreeNode(nums[midIdx])

            root.left = createdTree(left, midIdx -1)
            root.right = createdTree(midIdx + 1, right)
            return root
        }
        return createdTree(0, nums.size - 1)        
    }
}


object IterativeSolution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if(nums.isEmpty()) return null
        val firstMid = nums.size / 2
        val root = TreeNode(nums[firstMid])

        val queue: Queue<Step> = LinkedList()
        queue.add(Step(root, 0, firstMid -1))
        queue.add(Step(root, firstMid+1, nums.size - 1))

        while(queue.isNotEmpty()) {
            val step = queue.remove()
            val (parent, l, r) = step

            if(l > r) continue

            val node = TreeNode(nums[step.mid])

            if(parent.`val` > node.`val`) {
                parent.left = node
            } else {
                parent.right = node
            }
            
            queue.add(Step(node, l, step.mid - 1))
            queue.add(Step(node, step.mid + 1, r))
        }

        return root
    }
}

data class Step(val parent: TreeNode, val left: Int, val right: Int) {
    val mid = (left + right) / 2
}


object MyFirstSolution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if(nums.isEmpty()) return null
        val midIndex = midIndex(nums)
        val root = TreeNode(nums[midIndex])

        root.left = sortedArrayToBST(nums.leftSubtree())
        root.right = sortedArrayToBST(nums.rightSubtree())
        return root
    }

    fun midIndex(nums: IntArray): Int = (nums.size) / 2

    fun IntArray.leftSubtree(): IntArray {
        val midIndex = size / 2
        return sliceArray(0 .. midIndex - 1)
    }

    fun IntArray.rightSubtree(): IntArray {
        val midIndex = size / 2
        return sliceArray(midIndex + 1 .. size-1)
    }
}


