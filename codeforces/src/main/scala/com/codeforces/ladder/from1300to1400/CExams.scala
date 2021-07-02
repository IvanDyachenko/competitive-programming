package com.codeforces.ladder.from1300to1400

/** C. Exams
  * https://codeforces.com/problemset/problem/479/C
  */
object CExams extends App {
  import scala.io.StdIn._

  val n     = readInt()
  val dates = Array.fill(n) {
    val Array(ai, bi) = readLine().split(" ").map(_.toInt)
    ai -> bi // 1 <= bi < ai <= 10^9
  }

  val ans = dates.sorted.foldLeft(0) { case (day, (ai, bi)) => if (day > bi) ai else bi }

  println(ans)
}
