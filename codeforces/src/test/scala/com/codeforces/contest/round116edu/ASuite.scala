package com.codeforces.contest.round116edu

import munit.{ScalaCheckSuite, FunSuite}
import org.scalacheck.{Gen, Prop}
import A._

class ASuite extends FunSuite with ScalaCheckSuite {

  test("Codeforces | Round #116 | Educational | A | 1 test case") {
    assertEquals("b".abBalance, "b")
  }

  test("Codeforces | Round #116 | Educational | A | 2 test case") {
    assertEquals("aabbbabaa".abBalance, "aabbbabaa")
  }

  test("Codeforces | Round #116 | Educational | A | 3 test case") {
    assertEquals("abbb".abBalance, "bbbb")
  }

  test("Codeforces | Round #116 | Educational | A | 4 test case") {
    assertEquals("abbaab".abBalance, "bbbaab")
  }

  test("Codeforces | Round #116 | Educational | A | 5 test case") {
    assertEquals("aaaa".abBalance, "aaaa")
  }

  test("Codeforces | Round #116 | Educational | A | 6 test case") {
    assertEquals("abababa".abBalance, "abababa")
  }

  test("Codeforces | Round #116 | Educational | A | 7 test case") {
    assertEquals("aaabaaab".abBalance, "baabaaab")
  }

  test("Codeforces | Round #116 | Educational | A | 8 test case") {
    assertEquals("aabaaaaab".abBalance, "babaaaaab")
  }

  test("Codeforces | Round #116 | Educational | A | 9 test case") {
    assertEquals("aabaaaabb".abBalance, "babaaaabb")
  }

  test("Codeforces | Round #116 | Educational | A | 10 test case") {
    assertEquals("aabaaabbb".abBalance, "babaaabbb")
  }

  test("Codeforces | Round #116 | Educational | A | 11 test case") {
    assertEquals("ab".abBalance, "bb")
  }

  test("Codeforces | Round #116 | Educational | A | 12 test case") {
    assertEquals("aaabbaabbb".abBalance, "baabbaabbb")
  }

  property("Codeforces | Round #116 | Educational | A | stress test") {

    val inputGen: Gen[String] =
      for {
        n <- Gen.chooseNum(1, 100)
        input <- Gen.stringOfN(n, Gen.choose('a', 'b'))
      } yield input

    Prop.forAllNoShrink(inputGen) { (input) =>
      val output = input.abBalance
      val (ab, ba) = (output.sliding(2).count(_ == "ab"), output.sliding(2).count(_ == "ba"))
      assert(ab == ba, s"$ab != $ba $input -> $output")
    }
  }

}
