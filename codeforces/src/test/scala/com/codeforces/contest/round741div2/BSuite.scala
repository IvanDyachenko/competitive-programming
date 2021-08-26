package com.codeforces.contest.round741div2

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import B._

class BSuite extends FunSuite with ScalaCheckSuite {

  test("Codeforces | Round #741 | Div. 2 | B | 1 test case") {
    assertEquals(remove("237"), "27")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 2 test case") {
    assertEquals(remove("44444"), "4")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 3 test case") {
    assertEquals(remove("221"), "1")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 4 test case") {
    assertEquals(remove("35"), "35")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 5 test case") {
    assertEquals(remove("773"), "77")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 6 test case") {
    assertEquals(remove("4"), "4")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 7 test case") {
    assertEquals(remove("626221626221626221626221626221"), "6")
  }

  test("Codeforces | Round #741 | Div. 2 | B | 8 test case") {
    assertEquals(remove("33"), "33")
  }

}
