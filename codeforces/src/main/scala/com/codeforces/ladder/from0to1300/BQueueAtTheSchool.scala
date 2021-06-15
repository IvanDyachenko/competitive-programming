package com.codeforces.ladder.from0to1300

/** B. Queue at the School
  * - https://codeforces.com/problemset/problem/266/B
  */
object BQueueAtTheSchool extends App {
  import scala.io.StdIn._

  val Array(n, t) = readLine().split(" ").map(_.toInt)
  val s           = readLine()

  val ans = (0 until t).foldLeft(s) { case (s, _) => s.replace("BG", "GB") }

  println(ans)
}
