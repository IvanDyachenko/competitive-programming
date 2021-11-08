package com.leetcode.problems.easy

/** 977. Squares of a Sorted Array
  * https://leetcode.com/problems/squares-of-a-sorted-array/
  */
object SquaresOfASortedArray {

  def sortedSquares(an: Array[Int]): Array[Int] = {
    val n  = an.length
    val bn = Array.fill(n)(0)

    (n - 1).to(0, -1).foldLeft((0, n - 1)) { case ((left, right), index) =>
      val (nextLeft, nextRight) =
        if (math.abs(an(left)) > math.abs(an(right))) {
          bn(index) = an(left) * an(left)
          (left + 1, right)
        } else {
          bn(index) = an(right) * an(right)
          (left, right - 1)
        }

      (nextLeft, nextRight)
    }

    bn
  }

}
