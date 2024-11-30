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
    fun isSymmetric(root: TreeNode?): Boolean {
        return RecursiveSolution.isSymmetric(root)
        // return IterativeSolution.isSymmetric(root)
    }
}

/**
Time Complexity: O(n), n is the number of nodes.
Space Complexity: O(h), h is the height of the tree (recursive call stack)
 */
object RecursiveSolution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root == null) return true
        return isMirror(root.left, root.right)
    }

    fun isMirror(node1: TreeNode?, node2: TreeNode?): Boolean {
        if(node1 == null && node2 == null) return true
        if(node1 == null || node2 == null) return false

        if(node1.`val` != node2.`val`) return false
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left)
    }
}

/**
Time Complexity: O(n), n is the number of nodes
Space Complexity: O(w), w is the maximun width of the tree(numbeer of nodes in the widest level)
 */
object IterativeSolution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if(root == null) return false
        val queue = ArrayDeque<NodePair>()
        queue.add(NodePair(root.left, root.right))

        while(queue.isNotEmpty()) {
            val (left, right) = queue.removeFirst()
            if(left == null && right == null) continue
            if(left == null || right == null) return false
            if(left.`val` != right.`val`) return false

            queue.add(NodePair(left.left, right.right))
            queue.add(NodePair(left.right, right.left))
        }
        return true
    }

    data class NodePair(
        val left: TreeNode?,
        val right: TreeNode?,
    )
}
