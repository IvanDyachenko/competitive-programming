package com.leetcode.problems.medium

/** 98. Validate Binary Search Tree
  * https://leetcode.com/problems/validate-binary-search-tree/
  */
object ValidateBinarySearchTree {

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int      = _value
    var left: TreeNode  = _left
    var right: TreeNode = _right
  }

  object TreeNode {
    def unapply(node: TreeNode): Option[(Int, TreeNode, TreeNode)] =
      if (node == null) None else Some(node.value, node.left, node.right)
  }

  def isValidBST(root: TreeNode): Boolean = {
    @annotation.tailrec
    def go(nodes: List[(TreeNode, Option[Int], Option[Int])]): Boolean =
      nodes match {
        case (TreeNode(value, left, right), low, high) :: ns =>
          val gt = low.map(value > _).getOrElse(true)
          val lt = high.map(value < _).getOrElse(true)
          gt && lt && go((left, low, Some(value)) :: (right, Some(value), high) :: ns)
        case _ :: ns                                         => go(ns)
        case _                                               => true
      }
    go((root, None, None) :: Nil)
  }

}
