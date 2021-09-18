package com.codeforces.contest.round743div2

import munit.FunSuite
import A._

class ASuite extends FunSuite {

  test("Codeforces | Round #743 | Div. 2 | A | 1 test case") {
    val digits = "007".split("").map(_.toInt)
    assertEquals(countdown(digits), 7)
  }

  test("Codeforces | Round #743 | Div. 2 | A | 2 test case") {
    val digits = "1000".split("").map(_.toInt)
    assertEquals(countdown(digits), 2)
  }

  test("Codeforces | Round #743 | Div. 2 | A | 3 test case") {
    val digits = "00000".split("").map(_.toInt)
    assertEquals(countdown(digits), 0)
  }

  test("Codeforces | Round #743 | Div. 2 | A | 4 test case") {
    val digits = "103".split("").map(_.toInt)
    assertEquals(countdown(digits), 5)
  }

  test("Codeforces | Round #743 | Div. 2 | A | 5 test case") {
    val digits = "2020".split("").map(_.toInt)
    assertEquals(countdown(digits), 6)
  }

  test("Codeforces | Round #743 | Div. 2 | A | 6 test case") {
    val digits = "123456789".split("").map(_.toInt)
    assertEquals(countdown(digits), 53)
  }

  test("Codeforces | Round #743 | Div. 2 | A | 7 test case") {
    val digits = "001678294039710047203946100020".split("").map(_.toInt)
    assertEquals(countdown(digits), 115)
  }

}
