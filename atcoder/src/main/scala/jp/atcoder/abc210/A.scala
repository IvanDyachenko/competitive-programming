package jp.atcoder.abc210.A

/** A - Cabbages
  * https://atcoder.jp/contests/abc210/tasks/abc210_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(n, a, x, y) = readLine().split(" ").map(_.toInt)

  val ans = (n min a) * x + (0 max (n - a)) * y

  println(ans)
}
