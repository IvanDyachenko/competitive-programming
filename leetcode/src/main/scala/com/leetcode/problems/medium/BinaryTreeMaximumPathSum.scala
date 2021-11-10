package com.leetcode.problems.medium

/** 124. Binary Tree Maximum Path Sum
  * https://leetcode.com/problems/binary-tree-maximum-path-sum/
  */
object BinaryTreeMaximumPathSum {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int      = _value
    var left: TreeNode  = _left
    var right: TreeNode = _right
  }

  object TreeNode {
    def unapply(node: TreeNode): Option[(Int, TreeNode, TreeNode)] =
      if (node == null) None else Some(node.value, node.left, node.right)
  }

  def maxPathSum(root: TreeNode): Int = {
    def go(node: TreeNode): (Int, Int) =
      node match {
        case TreeNode(value, left, right) =>
          val (lmax, lincl) = go(left)
          val (rmax, rincl) = go(right)

          (
            (value + lincl + rincl) max lmax max rmax,
            0 max (value + (lincl max rincl))
          )
        case _                            => (Int.MinValue, 0)
      }

    go(root)._1
  }

}
