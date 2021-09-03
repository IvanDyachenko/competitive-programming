package com.facebook.`hacker-cup`.`2021`.`qualification-round`

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Gen, Prop}
import A1._

class A1Suite extends FunSuite with ScalaCheckSuite {

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 1 test case") {
    assertEquals(consistent("ABC"), 2)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 2 test case") {
    assertEquals(consistent("F"), 0)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 3 test case") {
    assertEquals(consistent("BANANA"), 3)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 4 test case") {
    assertEquals(consistent("FBHC"), 4)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 5 test case") {
    assertEquals(consistent("FOXEN"), 5)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 6 test case") {
    assertEquals(consistent("CONSISTENCY"), 12)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 7 test case") {
    assertEquals(consistent("HAAACKEEERCUUUP"), 17)
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 8 test case") {
    assertEquals(
      consistent(
        "OOEUEUIUUOOAUEIOIEEUIAIUAUOOAUUIIEUUOAAIOAEAUEIAOAOOAOOAAIEOAEOEIOIAAEAAIOEEOIIIEEIOIUEIEEEAAEEEEOAA"
      ),
      100
    )
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 9 test case") {
    assertEquals(
      consistent(
        "QPQWJXRJJXBTKKGBKVXNSCQBHZTSFZRYCDZFYQJQWHWHYJVDRXSGWRLJNTHBXYBRBTVXBBPPCXRBFVXVNDQQTHHBKXZDPQZGSHWF"
      ),
      100
    )
  }

  test("Facebook | Hacker Cup | 2021 | Qualification Round | A1 | 10 test case") {
    assertEquals(
      consistent(
        "EDHHDGFGCFHBHCAFGHHCBDHHECAEGGAGAGDGEGGFDGBCDFDCBHFGBDBCGHEACCGFAGEFBFGECFGFCGGBEDGDBFCEHEDHEHHFGCEB"
      ),
      94
    )
  }

}
