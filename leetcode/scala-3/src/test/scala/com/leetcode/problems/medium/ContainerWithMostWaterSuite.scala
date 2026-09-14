package com.leetcode.problems.medium

import munit.FunSuite
import ContainerWithMostWater.maxArea

class ContainerWithMostWaterSuite extends FunSuite {
  test("1") {
    assertEquals(maxArea(Array(1, 1)), 1)
  }
  test("2") {
    assertEquals(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)), 49)
  }
}
