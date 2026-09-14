package com.leetcode.problems.medium

import scala.annotation.tailrec

/** LeetCode #11: Container With Most Water
  *
  *   - https://leetcode.com/problems/container-with-most-water/
  *   - https://www.hellointerview.com/learn/code/two-pointers/container-with-most-water
  */
object ContainerWithMostWater:
  def maxArea(hs: Array[Int]): Int =
    def area(l: Int, r: Int): Int = (r - l) * (hs(r) min hs(l))

    @tailrec
    def go(a: Option[Int] = None)(l: Int, r: Int): Option[Int] =
      a match
        case _ if l >= r                => a
        case Some(a) if a >= area(l, r) =>
          val (i, j) = if hs(l) < hs(r) then (l + 1, r) else (l, r - 1)
          go(Some(a))(i, j)
        case _ => go(Some(area(l, r)))(l, r)

    go(None)(0, hs.length - 1) match
      case Some(area) => area
      case _          => 0
