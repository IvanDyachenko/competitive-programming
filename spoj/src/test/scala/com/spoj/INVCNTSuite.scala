package com.spoj

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import INVCNT._

class INVCNTSuite extends FunSuite with ScalaCheckSuite {

  test("SPOJ | INVCNT - Inversion Count | 1 test case") {
    assertEquals(Array.empty[Int].numberOfInversions, 0L)
  }

  test("SPOJ | INVCNT - Inversion Count | 2 test case") {
    assertEquals(Array(1, 2, 3, 4, 5).numberOfInversions, 0L)
  }

  test("SPOJ | INVCNT - Inversion Count | 3 test case") {
    assertEquals(Array(5, 4, 3, 2, 1).numberOfInversions, 10L)
  }

  override def scalaCheckTestParameters = super.scalaCheckTestParameters
    .withMinSuccessfulTests(1000)

  property("SPOJ | INVCNT - Inversion Count | stress testing") {

    def numberOfInversionsNaive(an: IndexedSeq[Int]): Long = {
      an.indices.foldLeft(0L) { (count, i) =>
        (0 until i).foldLeft(count) {
          case (c, j) if an(j) > an(i) => c + 1
          case (c, _)                  => c
        }
      }
    }

    Prop.forAll(Gen.listOf[Int](Gen.choose(1, 1000000000))) { (an: List[Int]) =>
      val bn = an.toArray
      assertEquals(bn.numberOfInversions, numberOfInversionsNaive(bn))
    }
  }
}
