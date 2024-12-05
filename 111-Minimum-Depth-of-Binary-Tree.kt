import kotlin.math.*

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
    private val worstMinDepth = 100000
    fun minDepth(root: TreeNode?): Int {
        return recursive(root)
        // return iterative(root, worstMinDepth)
    }

    fun recursive(root: TreeNode?): Int {
        if(root == null) return 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        var depth = 0
        while(queue.isNotEmpty()) {
            depth++
            repeat(queue.size) {
                val current = queue.poll() ?: return depth
                if(current.left == null && current.right == null) return depth
                current.left?.let(queue::add)
                current.right?.let(queue::add)
            }
        }
        return depth
    }

    fun iterative(root: TreeNode?, depth: Int): Int {
        return when {
            root == null || depth == 0 -> 0
            root.left == null && root.right == null -> 1
            root.left == null -> 1 + iterative(root.right, depth - 1)
            root.right == null -> 1 + iterative(root.left, depth - 1)
            else -> 1 + min(iterative(root.left, depth - 1) , iterative(root.right, depth - 1))
        }
    }

}