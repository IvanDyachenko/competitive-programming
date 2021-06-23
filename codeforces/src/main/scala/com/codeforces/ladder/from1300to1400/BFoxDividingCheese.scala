package com.codeforces.ladder.from1300to1400

/** B. Fox Dividing Cheese
  * https://codeforces.com/problemset/problem/371/B
  */
object BFoxDividingCheese extends App {
  import scala.io.StdIn._

  // if w mod 2 == 0 then eat 1/2 of w => w/2
  // if w mod 3 == 0 then eat 2/3 of w => w/3
  // if w mod 5 == 0 then eat 4/5 of w => w/5

  case class Slice(weight: Int, bites: Int*) {
    val (pieces, remains) = bites.foldLeft((Map.empty[Int, Int], weight)) { case ((pieces, weight), bite) =>
      @annotation.tailrec
      def go(w: Int, n: Int): (Int, Int) = if (w % bite == 0) go(w / bite, n + 1) else (w, n)

      val (w, n) = go(weight, pieces.getOrElse(bite, 0))
      (pieces + (bite -> n), w)
    }
  }

  val bites       = List(2, 3, 5)
  val Array(a, b) = readLine().split(" ").map(w => Slice(w.toInt, bites: _*))

  val ans =
    if (a.remains != b.remains) -1
    else bites.foldLeft(0) { case (count, bite) => count + math.abs(a.pieces(bite) - b.pieces(bite)) }

  println(ans)
}
