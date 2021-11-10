package com.leetcode.problems.medium

/** 42. Trapping Rain Water
  * https://leetcode.com/problems/trapping-rain-water/
  */
object TrappingRainWater {

  def trap(heights: Array[Int]): Int = {

    @annotation.tailrec
    def go(left: (Int, Int), right: (Int, Int), result: Int = 0): Int = {
      val (lmax, lpos) = left
      val (rmax, rpos) = right

      if (lpos >= rpos) result
      else {
        val (lheight, rheight) = (heights(lpos), heights(rpos))

        if (lheight > rheight) {
          go(left, (if (rheight > rmax) rheight else rmax, rpos - 1), result + 0.max(rmax - rheight))
        } else {
          go((if (lheight > lmax) lheight else lmax, lpos + 1), right, result + 0.max(lmax - lheight))
        }
      }
    }

    go(heights.head -> 0, heights.last -> (heights.length - 1))
  }

}
