package com.leetcode.problems.medium

import munit.FunSuite
import ValidTriangleNumber.triangleNumber

class ValidTriangleNumberSuite extends FunSuite {
  test("example 1") {
    val actual   = triangleNumber(Array(2, 2, 3, 4))
    val expected = 3

    assertEquals(actual, expected)
  }
  test("example 2") {
    val actual   = triangleNumber(Array(4, 2, 4, 3))
    val expected = 4

    assertEquals(actual, expected)
  }
  test("example 3") {
    val actual   = triangleNumber(Array(11, 4, 9, 6, 15, 18))
    val expected = 10

    assertEquals(actual, expected)
  }
}
