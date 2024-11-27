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
    val result = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        inorderSearch(root)
        return result
    }

    fun inorderSearch(node: TreeNode?) {        
        if(node == null) return
        inorderSearch(node.left)
        result.add(node.`val`)
        inorderSearch(node.right)
    }    
}
