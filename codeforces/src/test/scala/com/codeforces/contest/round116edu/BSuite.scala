package com.codeforces.contest.round116edu

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Prop, Gen}
import B._

class BSuite extends FunSuite with ScalaCheckSuite {

  test("Codeforces | Round #116 | Educational | B | 1 test case") {
    assertEquals(updateFiles(8L, 3L), 4L)
  }

  test("Codeforces | Round #116 | Educational | B | 2 test case") {
    assertEquals(updateFiles(6L, 6L), 3L)
  }

  test("Codeforces | Round #116 | Educational | B | 3 test case") {
    assertEquals(updateFiles(7L, 1L), 6L)
  }

  test("Codeforces | Round #116 | Educational | B | 4 test case") {
    assertEquals(updateFiles(1L, 1L), 0L)
  }

  test("Codeforces | Round #116 | Educational | B | 5 test case") {
    assertEquals(updateFiles(4L, 6L), 2L)
  }

}
