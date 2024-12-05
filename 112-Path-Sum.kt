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
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        return hasPathSum(root, targetSum, 0)
    }

    private fun hasPathSum(node: TreeNode, targetSum: Int, cummulatedSum: Int): Boolean {
        val currentCummulatedSum = cummulatedSum + node.`val`
        if(!node.hasChild()) {
            return targetSum == currentCummulatedSum
        }

        return (node.left?.let{ hasPathSum(it, targetSum, currentCummulatedSum) } ?: false) || 
            (node.right?.let { hasPathSum(it, targetSum, currentCummulatedSum) } ?: false)
    }
}

fun TreeNode.hasChild(): Boolean = left != null || right != null
