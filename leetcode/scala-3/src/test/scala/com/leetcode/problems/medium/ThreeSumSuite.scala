package com.leetcode.problems.medium

import munit.FunSuite
import scala.math.Ordering.Implicits.seqOrdering

class ThreeSumSuite extends FunSuite {
  test("Hello Interview example") {
    val actual   = ThreeSum.threeSum(Array(-1, 0, 1, 2, -1, -1)).map(_.sorted).sorted
    val expected = List(List(-1, -1, 2), List(-1, 0, 1))

    assertEquals(actual, expected)
  }
}
