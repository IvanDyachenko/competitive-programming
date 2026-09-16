package com.leetcode.problems.medium

import munit.FunSuite
import scala.math.Ordering.Implicits.seqOrdering

class ThreeSumSuite extends FunSuite {
  test("Hello Interview example") {
    val actual   = ThreeSum.threeSum(Array(-1, 0, 1, 2, -1, -1)).map(_.sorted).sorted
    val expected = List(List(-1, -1, 2), List(-1, 0, 1))

    assertEquals(actual, expected)
  }

  test("LeetCode example 1") {
    val actual   = ThreeSum.threeSum(Array(-1, 0, 1, 2, -1, -4)).map(_.sorted).sorted
    val expected = List(List(-1, -1, 2), List(-1, 0, 1))

    assertEquals(actual, expected)
  }

  test("LeetCode example 2") {
    val actual   = ThreeSum.threeSum(Array(0, 1, 1)).map(_.sorted).sorted
    val expected = List.empty[List[Int]]

    assertEquals(actual, expected)
  }

  test("LeetCode example 3") {
    val actual   = ThreeSum.threeSum(Array(0, 0, 0)).map(_.sorted).sorted
    val expected = List(List(0, 0, 0))

    assertEquals(actual, expected)
  }
}
