package com.codeforces.contest.round741div2

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import A._

class ASuite extends FunSuite with ScalaCheckSuite {

  test("Codeforces | Round #741 | Div. 2 | A | 1 test case") {
    assertEquals(remainder(1, 1), 0)
  }

  test("Codeforces | Round #741 | Div. 2 | A | 2 test case") {
    assertEquals(remainder(999999999, 1000000000), 1)
  }

  test("Codeforces | Round #741 | Div. 2 | A | 3 test case") {
    assertEquals(remainder(8, 26), 12)
  }

  test("Codeforces | Round #741 | Div. 2 | A | 4 test case") {
    assertEquals(remainder(1, 999999999), 499999999)
  }

  property("Codeforces | Round #741 | Div. 2 | A | stress test") {

    def remainderNaive(from: Int, to: Int): Int = (from to to).foldLeft(0) { (r, i) =>
      (i to to).foldLeft(r) { (r, j) => r max (j % i) }
    }

    val input: Gen[(Int, Int)] =
      for {
        l <- Gen.choose(1, 1000)
        r <- Gen.choose(l, l + 1000)
      } yield (l, r)

    Prop.forAllNoShrink(input) { case (l, r) => assertEquals(remainder(l, r), remainderNaive(l, r)) }
  }

}
