package com.codeforces.contest.deltix2021summer

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import A._

class ASuite extends FunSuite with ScalaCheckSuite {

  test("Codeforces | Deltix Round | Summer 2021 | A | 1 test case") {
    assertEquals(operations(1, 2), -1)
  }

  test("Codeforces | Deltix Round | Summer 2021 | A | 2 test case") {
    assertEquals(operations(3, 5), 2)
  }

  test("Codeforces | Deltix Round | Summer 2021 | A | 3 test case") {
    assertEquals(operations(5, 3), 2)
  }

  test("Codeforces | Deltix Round | Summer 2021 | A | 4 test case") {
    assertEquals(operations(6, 6), 1)
  }

  test("Codeforces | Deltix Round | Summer 2021 | A | 5 test case") {
    assertEquals(operations(8, 0), 2)
  }

  test("Codeforces | Deltix Round | Summer 2021 | A | 6 test case") {
    assertEquals(operations(0, 0), 0)
  }

}
