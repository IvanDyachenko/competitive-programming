package com.codeforces.ladder.from1300to1400

/** A. Jeff and Digits
  * - https://codeforces.com/problemset/problem/352/A
  */
object AJeffAndDigits extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt)

  val (fives, zeros) = (an.count(_ == 5), an.count(_ == 0))
  val count          = fives / 9

  val ans =
    if (count > 0 && zeros > 0) "5" * count * 9 + "0" * zeros
    else if (zeros > 0) "0"
    else -1

  println(ans)
}
