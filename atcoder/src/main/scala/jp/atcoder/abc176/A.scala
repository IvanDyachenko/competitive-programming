package jp.atcoder.abc176.A

/** A - Takoyaki
  * - https://atcoder.jp/contests/abc176/tasks/abc176_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(n, x, t) = readLine().split(" ").map(_.toInt)

  val ans = (n + x - 1) / x * t

  println(ans)
}
