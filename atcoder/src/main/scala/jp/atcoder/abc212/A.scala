package jp.atcoder.abc212.A

/** A - Alloy
  * https://atcoder.jp/contests/abc212/tasks/abc212_a
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(a, b) = readLine().split(" ").map(_.toInt)

  val ans = (a, b) match {
    case (0, _) => "Silver"
    case (_, 0) => "Gold"
    case _      => "Alloy"
  }

  println(ans)
}
