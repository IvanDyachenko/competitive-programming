package com.leetcode.problems.medium

import scala.annotation.tailrec

// LeetCode #15: 3Sum
// https://leetcode.com/problems/3sum/
// https://www.hellointerview.com/learn/code/two-pointers/3-sum
object ThreeSum:

  def threeSum(nums: Array[Int]): List[List[Int]] =
    val xs = nums.sorted

    @tailrec
    def go(i: Int, l: Int, r: Int)(rs: List[List[Int]]): List[List[Int]] =
      () match
        case _ if i + 2 >= xs.length || xs(i) > 0 =>
          rs

        case _ if l >= r || (i > 0 && xs(i) == xs(i - 1)) =>
          go(i + 1, i + 2, xs.length - 1)(rs)

        case _ if l > i + 1 && xs(l) == xs(l - 1) =>
          go(i, l + 1, r)(rs)

        case _ if r < xs.length - 1 && xs(r) == xs(r + 1) =>
          go(i, l, r - 1)(rs)

        case _ if xs(i) + xs(l) + xs(r) == 0 =>
          go(i, l + 1, r - 1)(List(xs(i), xs(l), xs(r)) :: rs)

        case _ if xs(i) + xs(l) + xs(r) > 0 =>
          go(i, l, r - 1)(rs)

        case _ =>
          go(i, l + 1, r)(rs)

    go(0, 1, xs.length - 1)(Nil)
