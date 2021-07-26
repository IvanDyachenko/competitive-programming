package jp.atcoder.arc124.A

/** A - LR Constraints
  * https://atcoder.jp/contests/arc124/tasks/arc124_a
  */
object Main extends App {
  import scala.io.StdIn._

  val mod         = 998244353L
  val Array(n, k) = readLine().split(" ").map(_.toInt)

  val cards = Array.fill(n)(k)

  (0 until k).foreach { _ =>
    readLine().split(" ") match {
      case Array("L", left)  =>
        val ki = left.toInt - 1
        cards(ki) = 1
        (0 until ki).foreach(j => cards(j) = 1 max (cards(j) - 1))
      case Array("R", right) =>
        val ki = right.toInt - 1
        cards(ki) = 1
        (ki until n).foreach(j => cards(j) = 1 max (cards(j) - 1))
    }
  }

  val answer = cards.foldLeft(1L)((a, b) => (a * b) % mod)

  println(answer)
}
