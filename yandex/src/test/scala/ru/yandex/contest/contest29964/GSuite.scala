package ru.yandex.contest.contest29964

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import G._

class GSuite extends FunSuite with ScalaCheckSuite {

  test("Yandex | Weekend Offer Backend | November 2021 | G | 1 test") {
    val ratings = Array.emptyIntArray
    assertEquals(ratings.bonuses(500), 0L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 2 test") {
    val ratings = Array(0)
    assertEquals(ratings.bonuses(500), 500L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 3 test") {
    val ratings = Array(0, 1)
    assertEquals(ratings.bonuses(500), 1500L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 4 test") {
    val ratings = Array(1, 0)
    assertEquals(ratings.bonuses(500), 1500L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 5 test") {
    val ratings = Array(0, 1, 2)
    assertEquals(ratings.bonuses(500), 3000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 6 test") {
    val ratings = Array(2, 1, 0)
    assertEquals(ratings.bonuses(500), 3000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 7 test") {
    val ratings = Array(1, 4, 3, 2, 2, 1, 4)
    assertEquals(ratings.bonuses(500), 6000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 8 test") {
    val ratings = Array.iterate(0, 4096)(_ + 1)
    assertEquals(ratings.bonuses(500), 4195328000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 9 test") {
    val ratings = Array.iterate(4096, 4096)(_ - 1)
    assertEquals(ratings.bonuses(500), 4195328000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 10 test") {
    val ratings = Array(5, 1, 3, 2, 4, 1, 6)
    assertEquals(ratings.bonuses(500), 5500L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 11 test") {
    val ratings = Array(1, 2, 3, 4)
    assertEquals(ratings.bonuses(500), 5000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 12 test") {
    val ratings = Array(5, 5, 5, 5)
    assertEquals(ratings.bonuses(500), 2000L)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | G | 13 test") {
    val ratings = Array(4, 2, 3, 3)
    assertEquals(ratings.bonuses(500), 3000L)
  }

}
