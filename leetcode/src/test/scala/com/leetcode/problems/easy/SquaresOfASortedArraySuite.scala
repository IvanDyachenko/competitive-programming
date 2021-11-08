package com.leetcode.problems.easy

import munit.FunSuite
import SquaresOfASortedArray._

class SquaresOfASortedArraySuite extends FunSuite {

  test("Leetcode | 977. Squares of a Sorted Array | 1 test case") {
    val an = Array(-4, -1, 0, 3, 10)
    val bn = sortedSquares(an)
    assert(bn sameElements an.map(a => a * a).sorted, bn.mkString(" "))
  }

  test("Leetcode | 977. Squares of a Sorted Array | 2 test case") {
    val an = Array(-7, -3, 2, 3, 11)
    val bn = sortedSquares(an)
    assert(bn sameElements an.map(a => a * a).sorted, bn.mkString(" "))
  }

  test("Leetcode | 977. Squares of a Sorted Array | 3 test case") {
    val an = Array(-3, -2, -1)
    val bn = sortedSquares(an)
    assert(bn sameElements an.map(a => a * a).sorted, bn.mkString(" "))
  }


  test("Leetcode | 977. Squares of a Sorted Array | 4 test case") {
    val an = Array(1, 2, 3, 4, 5)
    val bn = sortedSquares(an)
    assert(bn sameElements an.map(a => a * a).sorted, bn.mkString(" "))
  }

}
