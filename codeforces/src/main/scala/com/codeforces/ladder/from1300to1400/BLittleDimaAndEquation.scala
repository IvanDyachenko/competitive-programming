package com.codeforces.ladder.from1300to1400

/** B. Little Dima and Equation
  * - https://codeforces.com/problemset/problem/460/B
  */
object BLittleDimaAndEquation extends App {
  import scala.io.StdIn._

  //1<=a<=5, 1<=b<=10000, -10000<=c<=10000
  val Array(a, b, c) = readLine().split(" ").map(_.toLong)

  // x = b * s(x)^a + c
  // 0<x<10^9 -> 1<=s(x)<=81

  val ans = (1 to 81).map { sx =>
    val x = b * math.pow(sx, a).toLong + c
    (x, sx)
  }.filter { case (x, _) => 0L < x && x < 1000000000L }.collect {
    case (x, sx) if sx == x.toString.map(_ - '0').sum => x
  }

  println(ans.length)
  if (ans.nonEmpty) println(ans.mkString(" "))
}
