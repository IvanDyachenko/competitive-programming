package jp.atcoder.abc203.A

/** A - Chinchirorin
  * - https://atcoder.jp/contests/abc203/tasks/abc203_a
  */
object Main extends App {
  import scala.io.StdIn._

  val dices = readLine().split(" ").map(_.toInt)
  val ans   =
    if (dices.distinct.length == 3) 0
    else dices.reduce(_ ^ _)

  println(ans)
}
