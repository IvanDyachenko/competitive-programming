package jp.atcoder.abc176.C

/** C - Step
  * - https://atcoder.jp/contests/abc176/tasks/abc176_c
  */
object Main extends App {
  import scala.io.StdIn._

  val n  = readInt()
  val an = readLine().split(" ").map(_.toInt)

  // format: off
  val ans = an
    .foldLeft((0L, 0)) { case ((total, height), a) =>
      (total + 0.max(height - a), a max height)
    }
    ._1

  println(ans)
}
