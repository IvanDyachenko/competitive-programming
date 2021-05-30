package jp.atcoder.abc176.B

/** B - Multiple of 9
  * - https://atcoder.jp/contests/abc176/tasks/abc176_b
  */
object Main extends App {
  import scala.io.StdIn._

  val n = readLine()

  val ans = n.foldLeft(0L)(_ + _ - 48) % 9 match {
    case 0 => "Yes"
    case _ => "No"
  }

  println(ans)
}
