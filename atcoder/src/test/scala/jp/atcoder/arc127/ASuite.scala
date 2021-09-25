package jp.atcoder.arc127.A

import munit.FunSuite
import Main._

class ASuite extends FunSuite {

  test("AtCoder Regular Contest 127 | A | 1 test case") {
    assertEquals(leading1s(11L), 4L)
  }

  test("AtCoder Regular Contest 127 | A | 2 test case") {
    assertEquals(leading1s(120L), 44L)
  }

  test("AtCoder Regular Contest 127 | A | 3 test case") {
    assertEquals(leading1s(987654321L), 123456789L)
  }

}
