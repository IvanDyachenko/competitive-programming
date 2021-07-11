package com.codeforces.contest.round732div2

/** C. AquaMoon and Strange Sort
  * https://codeforces.com/contest/1546/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  def f: Array[Int] => Map[Int, (Int, Int)] =
    _.zipWithIndex.foldLeft(Map.empty[Int, (Int, Int)]) { case (map, (ai, i)) =>
      val (even, odd) = map.getOrElse(ai, (0, 0))
      map.updated(ai, if (i % 2 == 0) (even + 1, odd) else (even, odd + 1))
      // map.updatedWith(ai) {
      //   case Some((even, odd)) => if (i % 2 == 0) Some(even + 1, odd) else Some(even, odd + 1)
      //   case None              => if (i % 2 == 0) Some(1, 0) else Some(0, 1)
      // }
    }

  val t = readInt()

  (0 until t).foreach { _ =>
    val n  = readInt()
    val an = readLine().split(" ").map(_.toInt)

    val ans: Boolean = {
      val (amap, bmap) = (f(an), f(an.sorted))
      amap.foldLeft(true) { case (result, (ai, count)) => result && bmap(ai) == count }
    }

    ans match {
      case true => println("yes")
      case _    => println("no")
    }
  }
}
