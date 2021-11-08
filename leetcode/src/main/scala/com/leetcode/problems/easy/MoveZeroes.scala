package com.leetcode.problems.easy

/** 283. Move Zeroes
  * https://leetcode.com/problems/move-zeroes/
  */
object MoveZeroes {

  def moveZeroes(xs: Array[Int]): Unit = {
    val last = xs.zipWithIndex.foldLeft(0) {
      case (last, (0, i)) => last
      case (last, (x, i)) => xs(last) = x; last + 1
    }

    (last until xs.length).foreach(xs(_) = 0)
  }

}
