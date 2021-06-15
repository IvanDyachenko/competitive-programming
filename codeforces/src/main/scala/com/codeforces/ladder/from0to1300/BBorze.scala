package com.codeforces.ladder.from0to1300

/** B. Borze
  * - https://codeforces.com/problemset/problem/32/B
  */
object BBorze extends App {
  import scala.io.StdIn._

  val ans = readLine().replace("--", "2").replace("-.", "1").replace(".", "0")

  println(ans.mkString(""))
}
