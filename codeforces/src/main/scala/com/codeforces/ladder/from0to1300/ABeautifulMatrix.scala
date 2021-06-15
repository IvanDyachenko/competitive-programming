package com.codeforces.ladder.from0to1300

/** A. Beautiful Matrix
  * - https://codeforces.com/problemset/problem/263/A
  */
object ABeautifulMatrix extends App {
  import scala.io.StdIn._

  val IndexedSeq(ans) = for {
    i  <- 1 to 5
    row = readLine() if row.contains('1')
  } yield ((3 - i).abs, (2 - row.indexOf("1") / 2).abs)

  println(ans._1 + ans._2)
}
