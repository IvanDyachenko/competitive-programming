package com.csacademy.task

import munit.FunSuite
import ClassicTask._

class ClassicTaskSuite extends FunSuite {

  test("CS Academy | Classic Task | 1 test case") {
    val matrix = Array(
      Array(10L),
      Array(47L),
      Array(17L)
    )

    assertEquals(matrix.hirschberg, List(Down, Down))
  }

  test("CS Academy | Classic Task | 2 test case") {
    val matrix = Array(
      Array(0L, 3L),
      Array(3L, 0L)
    )

    assertEquals(matrix.hirschberg, List(Right, Down))
  }

  test("CS Academy | Classic Task | 3 test case") {
    val matrix = Array(
      Array(12421L, 69L, 41332L, 7L, 199L, 4893L),
      Array(12646L, 472L, 41185L, 402L, 336L, 4744L),
      Array(13344L, 1122L, 42409L, 1240L, 1054L, 6082L),
      Array(12423L, 199L, 41228L, 117L, 181L, 4975L),
      Array(12501L, 149L, 41300L, 39L, 231L, 4925L)
    )

    assertEquals(matrix.hirschberg, List(Right, Right, Right, Right, Down, Down, Down, Down, Right))
  }

}
