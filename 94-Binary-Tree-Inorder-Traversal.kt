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
        // inorderSearchRecursive(root)
        inorderSearchIterative(root)
        return result
    }

    fun inorderSearchRecursive(node: TreeNode?) {        
        if(node == null) return
        inorderSearchRecursive(node.left)
        result.add(node.`val`)
        inorderSearchRecursive(node.right)
    }    

    fun inorderSearchIterative(node: TreeNode?) {
        val stack = Stack<TreeNode>()
        var current = node

        while(current != null || stack.isNotEmpty()) {
            while(current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            result.add(current.`val`)
            current = current.right
        }
    }

}
