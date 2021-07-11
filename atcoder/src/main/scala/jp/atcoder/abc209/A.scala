package jp.atcoder.abc209.A

/** A - Counting
  * https://atcoder.jp/contests/abc209/tasks/abc209_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(a, b) = readLine().split(" ").map(_.toInt)

  val ans = 0 max (b - a + 1)

  println(ans)
}
