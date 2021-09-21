package com.spoj

import munit.FunSuite
import CLOPPAIR._

class CLOPPAIRSuite extends FunSuite {

  test("SPOJ | CLOPPAIR - Closest Point Pair | 1 test case") {
    val points = Array(
      Point(0, 0),
      Point(0, 1),
      Point(100, 45),
      Point(2, 3),
      Point(9, 9)
    )

    assertEquals(points.closest, Some((1.0, 0, 1)))
  }

}
