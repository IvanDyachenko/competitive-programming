package ru.yandex.contest.contest29964

import munit.FunSuite
import C._

class CSuite extends FunSuite {

  test("Yandex | Weekend Offer Backend | November 2021 | C | 1 test") {
    val field = Array(
      Array(true, true),
      Array(true, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 2 test") {
    val field = Array(
      Array(false, true),
      Array(true, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 3 test") {
    val field = Array(
      Array(true, false),
      Array(true, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 4 test") {
    val field = Array(
      Array(true, true),
      Array(false, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 5 test") {
    val field = Array(
      Array(true, true),
      Array(true, false)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 6 test") {
    val field = Array(
      Array(false, false),
      Array(true, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 7 test") {
    val field = Array(
      Array(false, true),
      Array(false, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 8 test") {
    val field = Array(
      Array(false, true),
      Array(true, false)
    )
    assertEquals(field.minesweeper, 2)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 9 test") {
    val field = Array(
      Array(false, true),
      Array(false, false)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 10 test") {
    val field = Array(
      Array(false, false),
      Array(false, false)
    )
    assertEquals(field.minesweeper, 0)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 11 test") {
    val field = Array(
      Array(true, true, true),
      Array(false, false, false),
      Array(true, true, true)
    )
    assertEquals(field.minesweeper, 2)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 12 test") {
    val field = Array(
      Array(true, true, true),
      Array(false, false, true),
      Array(true, true, true)
    )
    assertEquals(field.minesweeper, 1)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 13 test") {
    val field = Array.fill(100, 100)(false)

    assertEquals(field.minesweeper, 0)
  }

  test("Yandex | Weekend Offer Backend | November 2021 | C | 14 test") {
    val field = Array.fill(100, 100)(true)

    assertEquals(field.minesweeper, 1)
  }

}
