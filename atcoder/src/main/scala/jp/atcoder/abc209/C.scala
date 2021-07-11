package jp.atcoder.abc209.C

/** C - Not Equal
  * https://atcoder.jp/contests/abc209/tasks/abc209_c
  */
object Main extends App {
  import scala.io.StdIn._

  val Mod = (1e9 + 7).toLong

  val n  = readInt()
  val cn = readLine().split(" ").map(_.toInt).sorted

  val ans = cn.zipWithIndex.foldLeft(1L) { case (count, (ci, i)) => (count * (ci - i)) % Mod }

  println(ans)
}
