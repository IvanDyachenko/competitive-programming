package com.leetcode.problems.medium

import scala.annotation.tailrec

// LeetCode #611: Valid Triangle Number
// https://leetcode.com/problems/valid-triangle-number/
// https://www.hellointerview.com/learn/code/two-pointers/valid-triangle-number
object ValidTriangleNumber:
  def triangleNumber(ns: Array[Int]): Int =
    val xs = ns.sorted
    val l  = xs.length

    @tailrec
    def go(a: Int, b: Int, c: Int)(count: Int): Int =
      () match
        case _ if c < 2                 => count
        case _ if a >= b                => go(0, c - 2, c - 1)(count)
        case _ if xs(a) + xs(b) > xs(c) => go(0, b - 1, c)(count + b - a)
        case _                          => go(a + 1, b, c)(count)

    go(0, l - 2, l - 1)(0)
