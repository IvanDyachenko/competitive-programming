package com.leetcode.problems.medium

import munit.FunSuite
import DeleteNodeInBST._

class DeleteNodeInBSTSuite extends FunSuite {

  test("LeetCode | 450. Delete Node in a BST | 1 test case") {
    val tree = Tree(1)
    assertEquals(tree.delete(1), None)
  }

  test("LeetCode | 450. Delete Node in a BST | 2 test case") {
    val tree = Tree(1)
    assertEquals(tree.delete(2), Some(tree))
  }

  test("LeetCode | 450. Delete Node in a BST | 3 test case") {
    val tree = Tree(5, Some(Tree(3)))
    assertEquals(tree.delete(3), Some(Tree(5)))
  }

  test("LeetCode | 450. Delete Node in a BST | 4 test case") {
    val tree = Tree(5, None, Some(Tree(6)))
    assertEquals(tree.delete(6), Some(Tree(5)))
  }

  test("LeetCode | 450. Delete Node in a BST | 5 test case") {
    val tree = Tree(5, Some(Tree(3)))
    assertEquals(tree.delete(5), Some(Tree(3)))
  }

  test("LeetCode | 450. Delete Node in a BST | 6 test case") {
    val tree = Tree(5, None, Some(Tree(6)))
    assertEquals(tree.delete(5), Some(Tree(6)))
  }

  test("LeetCode | 450. Delete Node in a BST | 7 test case") {
    val tree = Tree(5, Some(Tree(3, Some(Tree(2)), Some(Tree(4)))), Some(Tree(6, None, Some(Tree(7)))))
    assertEquals(tree.delete(3), Some(Tree(5, Some(Tree(4, Some(Tree(2)))), Some(Tree(6, None, Some(Tree(7)))))))
  }

}
