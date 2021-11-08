package ru.yandex.contest.contest29964

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import B._

class BSuite extends FunSuite with ScalaCheckSuite {

  test("Yandex | Weekend Offer Backend | November 2021 | B | 1 test") {
    val period    = 7
    val clicks    = 12
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(27L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 2 test") {
    val period    = 7
    val clicks    = 11
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(26L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 3 test") {
    val period    = 7
    val clicks    = 10
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(24L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 4 test") {
    val period    = 7
    val clicks    = 9
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(22L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 5 test") {
    val period    = 7
    val clicks    = 8
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(20L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 6 test") {
    val period    = 7
    val clicks    = 7
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(19L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 7 test") {
    val period    = 7
    val clicks    = 6
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(17L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 8 test") {
    val period    = 7
    val clicks    = 5
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(15L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 9 test") {
    val period    = 7
    val clicks    = 4
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(13L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 10 test") {
    val period    = 7
    val clicks    = 3
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(12L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 11 test") {
    val period    = 7
    val clicks    = 2
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(8L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 12 test") {
    val period    = 7
    val clicks    = 1
    val deadlines = Array(5, 8, 13, 17, 22)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(5L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 13 test") {
    val period    = 2
    val clicks    = 4
    val deadlines = Array(3)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(9L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 14 test") {
    val period    = 2
    val clicks    = 3
    val deadlines = Array(3)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(7L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 15 test") {
    val period    = 2
    val clicks    = 2
    val deadlines = Array(3)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(5L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 16 test") {
    val period    = 2
    val clicks    = 1
    val deadlines = Array(3)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(3L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 17 test") {
    val period    = 9
    val clicks    = 7
    val deadlines = Array(41, 45, 33, 9, 38)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(41L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 18 test") {
    val period    = 10000000
    val clicks    = 1000000000
    val deadlines = (1 to 100000).toArray

    assertEquals(technicalDebt(period, clicks, deadlines), Some(99990100000L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 19 test") {
    val period    = 1000
    val clicks    = 1000000000
    val deadlines = (1 to 100000).toArray

    assertEquals(technicalDebt(period, clicks, deadlines), Some(1000000000L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 20 test") {
    val period    = 5
    val clicks    = 10
    val deadlines = Array(1, 2, 3, 4, 5, 6)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(10L))
  }

  test("Yandex | Weekend Offer Backend | November 2021 | B | 21 test") {
    val period    = 7
    val clicks    = 12
    val deadlines = Array(5, 22, 17, 13, 8)

    assertEquals(technicalDebt(period, clicks, deadlines), Some(27L))
  }


  property("Yandex | Weekend Offer Backend | November 2021 | B | stress test") {

    val inputGen: Gen[(Int, Int, List[Int])] =
      for {
        period    <- Gen.choose(1, 100)
        clicks    <- Gen.choose(1, 100)
        size      <- Gen.choose(1, 1000)
        deadlines <- Gen.listOfN(size, Gen.choose(1, 1000))
      } yield (period, clicks, deadlines)

    def technicalDebtNaive(period: Int, clicks: Int, deadlines: Seq[Int]): Option[Long] = {
      val notifications = deadlines.flatMap { deadline =>
        (0 until clicks).map { i => deadline + i * period }
      }.distinct.sorted
      Some(notifications(clicks - 1))
    }

    Prop.forAllNoShrink(inputGen) { case (period, clicks, days) =>
      val deadlines = days.toArray
      assertEquals(technicalDebt(period, clicks, deadlines), technicalDebtNaive(period, clicks, deadlines))
    }

  }

}
