package com.facebook.`hacker-cup`.`2021`.`qualification-round`

/** Problem A1: Consistency - Chapter 1
  * https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/A1
  */
object A1 extends App {

  def isVowel: Char => Boolean = _ match {
    case 'A' | 'E' | 'I' | 'O' | 'U' => true
    case _                           => false
  }

  def consistent(input: String): Int = {
    val (vowels, consonants) = input
      .groupMapReduce(identity)(_ => 1)(_ + _)
      .toList
      .sortBy { case (_, count) => count }(Ordering[Int].reverse)
      .partitionMap { case (letter, count) => Either.cond(isVowel(letter), count, count) }

    (vowels.size, consonants.size) match {
      case (_, 0) => input.length min (2 * vowels.tail.sum)
      case (0, _) => input.length min (2 * consonants.tail.sum)
      case _      => (consonants.sum + 2 * vowels.tail.sum) min (vowels.sum + 2 * consonants.tail.sum)
    }
  }

  import scala.io.StdIn._

  val t = readInt()

  (0 until t).map { i =>
    val s = readLine()
    println(s"Case #${i + 1}: ${consistent(s)}")
  }

}
