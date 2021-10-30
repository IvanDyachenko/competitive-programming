package jp.atcoder.abc255.C

import munit.FunSuite
import Main._

class CSuite extends FunSuite {

  test("AtCoder Beginner Contest 225 | C | 1 test case") {
    val calendar = Array(
      Array(1, 2, 3, 4, 5, 6, 7),
      Array(8, 9, 10, 11, 12, 13, 14)
    )

    assert(calendarValidator(calendar))
  }

  test("AtCoder Beginner Contest 225 | C | 2 test case") {
    val calendar = Array(
      Array(1, 2, 3),
      Array(8, 9, 10)
    )

    assert(calendarValidator(calendar))
  }

  test("AtCoder Beginner Contest 225 | C | 3 test case") {
    val calendar = Array(
      Array(1),
      Array(2)
    )

    assert(!calendarValidator(calendar))
  }

}
