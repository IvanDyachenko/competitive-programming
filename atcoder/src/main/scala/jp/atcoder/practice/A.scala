package jp.atcoder.practice.A

/** A - Welcome to AtCoder
  * - https://atcoder.jp/contests/practice/tasks/practice_1
  */
object Main extends App {
  import scala.io.StdIn._

  val a           = readInt()
  val Array(b, c) = readLine().split(" ").map(_.toInt)
  val s           = readLine()

  val ans = s"${a + b + c} $s"

  println(ans)
}
