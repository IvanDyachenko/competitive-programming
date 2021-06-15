package com.codeforces.ladder.from0to1300

/** A. Nearly Lucky Number
  * - https://codeforces.com/problemset/problem/110/A
  */
object ANearlyLuckyNumber extends App {
  import scala.io.StdIn._

  def isLuckyDigit(digit: Char): Boolean           = digit == '4' || digit == '7'
  def isLuckyNumber(number: String): Boolean       = number.forall(isLuckyDigit)
  def isNearlyLuckyNumber(number: String): Boolean = isLuckyNumber(number.count(isLuckyDigit).toString)

  val ans =
    if (isNearlyLuckyNumber(readLine())) "YES"
    else "NO"

  println(ans)
}
