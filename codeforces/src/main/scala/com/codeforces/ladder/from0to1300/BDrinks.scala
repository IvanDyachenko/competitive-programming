package com.codeforces.ladder.from0to1300

/** B. Drinks
  * - https://codeforces.com/problemset/problem/200/B
  */
object BDrinks extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val pn = readLine().split(" ").map(_.toInt)

  val ans = pn.sum.toDouble / n

  println(ans)
}
