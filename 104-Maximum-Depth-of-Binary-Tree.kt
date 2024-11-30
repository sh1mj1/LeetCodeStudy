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
    fun maxDepth(root: TreeNode?): Int {
        // return MySolution.maxDepth(root)
        // return IterativeSolution.maxDepth(root)
        return RecursiveSolution.maxDepth(root)
    }
}

/**
Time Complexity: O(n), n is the number of nodes.
Space Complexity: O(h), h is the height of the tree (recursive call stack)
 */
object RecursiveSolution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        return 1 + maxOf(leftDepth, rightDepth)
    }
}

/**
Time Complexity: O(n) n is the number of nodes.
Space Complexity: O(w) w is the maximum number of nodes at any level
 */
object IterativeSolution {
    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        val queue = ArrayDeque<TreeNode?>()
        queue.add(root)
        var depth = 0

        while(queue.isNotEmpty()) {
            val size = queue.size
            repeat(size) {
                val node = queue.removeFirst()
                if(node?.left != null) queue.add(node.left)
                if(node?.right != null) queue.add(node.right)
            }
            depth++
        }
        return depth
    }
}

object MySolution {
    var maxDepth: Int = 1

    fun maxDepth(root: TreeNode?): Int {
        if(root == null) return 0
        traversalForMaxDepth(root, maxDepth)
        return maxDepth
    }
    fun traversalForMaxDepth(node: TreeNode?, currentDepth: Int) {
        if(node == null) return
        if(currentDepth > maxDepth) {
            maxDepth = currentDepth
        }
        traversalForMaxDepth(node.left, currentDepth + 1)
        traversalForMaxDepth(node.right, currentDepth + 1)
    }
}
