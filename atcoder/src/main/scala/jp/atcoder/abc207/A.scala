package jp.atcoder.abc207.A

/** A - Repression
  * https://atcoder.jp/contests/abc207/tasks/abc207_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(a, b, c) = readLine().split(" ").map(_.toInt)

  val ans = a + b + c - (a min b min c)

  println(ans)
}
