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
    
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return stackApproach(p, q)
    }

    fun recursiveApproach(p: TreeNode?, q: TreeNode?): Boolean {
        if(p == null && q == null) return true
        if(p == null && q != null) return false
        if(p != null && q == null) return false
        if(p!!.`val` != q!!.`val`) return false
        if(p.left == null && q.left != null) return false
        if(p.left != null && q.left == null) return false
        if(p.right == null && q.right != null) return false
        if(p.right != null && q.right == null) return false

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }

    fun stackApproach(p: TreeNode?, q: TreeNode?): Boolean {
        val stack = Stack<Pair<TreeNode?, TreeNode?>>()
        stack.push(Pair(p, q))

        while (stack.isNotEmpty()) {
            val (node1, node2) = stack.pop()
            if (node1 == null && node2 == null) continue
            if(node1 == null || node2 == null) return false
            if(node1.`val` != node2.`val`) return false
            
            stack.push(Pair(node1.left, node2.left))
            stack.push(Pair(node1.right, node2.right))
        }

        return true 
    }
}


/*
Approach:
    Base Case:
        If both nodes are null, the trees are identical up to this point.
        If one is null and the other isn't, the trees aren't identical.

    Recursive Case:
        Compare the values of the current nodes.
        Recursively check the left and right subtrees.

Alternatively, I can use the iterative approach using stack.

The time complexity is O(n), 
where n is the number of nodes in the tree, as we visit each node once.

The space complexity is O(h), 
where h is the height of the tree due to the recursive call stack.
 */



