package com.codeforces.round630div2

/** D. Walk on Matrix
  * - https://codeforces.com/contest/1332/problem/D
  * - https://competitiveprogrammingdiscuss.blogspot.com/2020/04/codeforces-round-630-div-2-problem-d.html
  */
object D extends App {
  val k = scala.io.StdIn.readInt()
  val a = 1 << 17

  println("2 3")
  println(s"${a ^ k} $a 0")
  println(s"$k ${a ^ k} $k")
}
