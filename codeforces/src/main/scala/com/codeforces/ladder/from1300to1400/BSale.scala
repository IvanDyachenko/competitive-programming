package com.codeforces.ladder.from1300to1400

/** B. Sale
  * - https://codeforces.com/problemset/problem/34/B
  */
object BSale extends App {
  import scala.io.StdIn._

  val Array(n, m) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt).sorted

  val ans = an.take(m).foldLeft(0) { case (bellars, ai) => bellars - (0 min ai) }

  println(ans)
}
