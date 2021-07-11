package jp.atcoder.abc209.B

/** B - Can you buy them all?
  * https://atcoder.jp/contests/abc209/tasks/abc209_b
  */
object Main extends App {
  import scala.io.StdIn._

  val Array(n, x) = readLine().split(" ").map(_.toInt)
  val an          = readLine().split(" ").map(_.toInt)

  val ans = x >= an.sum - n / 2

  ans match {
    case true => println("Yes")
    case _    => println("No")
  }
}
