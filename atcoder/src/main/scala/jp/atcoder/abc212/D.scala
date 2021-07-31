package jp.atcoder.abc212.D

/** D - Querying Multiset
  * https://atcoder.jp/contests/abc212/tasks/abc212_d
  */
object Main extends App {
  import scala.io.StdIn._
  import scala.collection.mutable.PriorityQueue

  val pq = PriorityQueue.empty[Long](Ordering[Long].reverse)

  val q = readInt()

  (0 until q).foldLeft(0L) { case (shift, _) =>
    readLine().split(" ").map(_.toLong) match {
      case Array(1, x) =>
        pq.enqueue(x - shift)
        shift
      case Array(2, x) => shift + x
      case Array(3)    =>
        val x = pq.dequeue() + shift
        println(x)
        shift
    }
  }
}
