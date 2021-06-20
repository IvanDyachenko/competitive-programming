package com.codeforces.round637div2

/** B. Nastya and Door
  * - https://codeforces.com/contest/1341/problem/B
  */
object B extends App {
  val t = scala.io.StdIn.readInt()

  private def ridge(an: Vector[Int], k: Int): (Int, Int) = {
    val n = an.length

    val peaks = an.indices.map { i =>
      if (i == 0 || i == n - 1) 0
      else if (an(i - 1) < an(i) && an(i) > an(i + 1)) 1
      else 0
    }

    val prefixes = Array.fill(n)(0)
    (1 until n).foreach(i => prefixes(i) = prefixes(i - 1) + peaks(i))

    (0 to (n - k)).foldLeft((0, 0)) { case ((t, l), i) =>
      val f = prefixes(i + k - 2) - prefixes(i)

      if (f > t) (f, i)
      else (t, l)
    }
  }

  (0 until t).foreach { _ =>
    val Array(_, k) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
    val an          = scala.io.StdIn.readLine().split(" ").map(_.toInt).toVector

    val (t, l) = ridge(an, k)

    println(s"${t + 1} ${l + 1}")
  }
}
