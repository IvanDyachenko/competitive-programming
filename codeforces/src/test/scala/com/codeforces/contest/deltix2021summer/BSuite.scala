package com.codeforces.contest.deltix2021summer

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import B._

class BSuite extends FunSuite with ScalaCheckSuite {

  test("Codeforces | Deltix Round | Summer 2021 | B | 1 test case") {
    assertEquals(swaps(Array(6, 6, 1)), Some(1))
  }

  test("Codeforces | Deltix Round | Summer 2021 | B | 2 test case") {
    assertEquals(swaps(Array(9)), Some(0))
  }

  test("Codeforces | Deltix Round | Summer 2021 | B | 3 test case") {
    assertEquals(swaps(Array(1, 1, 1, 2, 2, 2)), Some(3))
  }

  test("Codeforces | Deltix Round | Summer 2021 | B | 4 test case") {
    assertEquals(swaps(Array(8, 6)), None)
  }

  test("Codeforces | Deltix Round | Summer 2021 | B | 5 test case") {
    assertEquals(swaps(Array(6, 2, 3, 4, 5, 1)), Some(2))
  }

}
