package jp.atcoder.abc210.B

/** B - Bouzu Mekuri
  * https://atcoder.jp/contests/abc210/tasks/abc210_b
  */
object Main extends App {
  import scala.io.StdIn._

  val n = readInt()
  val s = readLine()

  val ans = if (s.indexOf('1') % 2 == 0) "Takahashi" else "Aoki"

  println(ans)
}
