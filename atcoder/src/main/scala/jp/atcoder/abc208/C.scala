package jp.atcoder.abc208.C

/** C - Fair Candy Distribution
  * https://atcoder.jp/contests/abc208/tasks/abc208_c
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(_, k) = readLine().split(" ").map(_.toLong)
  val an          = readLine().split(" ").map(_.toInt)
  val n           = an.length
  val bn          = (0 until n).sortBy(an(_))

  val ans = {
    val t  = k / n
    val ps = Array.fill(n)(t)
    (0 until (k - t * n).toInt).foreach(i => ps(bn(i)) += 1)
    ps
  }

  println(ans.mkString("\n"))
}
