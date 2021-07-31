package jp.atcoder.abc212.B

/** B - Weak Password
  * https://atcoder.jp/contests/abc212/tasks/abc212_b
  */
object Main extends App {
  import scala.io.StdIn._

  val xs = readLine().split("").map(_.toInt)

  val first  = xs.distinct.length == 1
  val second = xs.sliding(2).forall { case Array(a, b) => (a + 1) % 10 == b }

  (first || second) match {
    case true => println("Weak")
    case _    => println("Strong")
  }
}
