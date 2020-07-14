package com.codeforces.round85edu

/**
  * C. Circle of Monsters
  * https://codeforces.com/contest/1334/problem/C
  */
object C extends App {
  import scala.io.StdIn._

  case class Monster(h: Long, e: Long)

  val t = readInt()

  (0 until t).foreach { _ =>
    val n = readInt()
    val mn = (0 until n).foldLeft(Array.ofDim[Monster](n)) { (ms, i) =>
      val Array(h, e) = readLine().split(" ").map(_.toLong)
      ms(i) = Monster(h, e)
      ms
    }

    val (bs, b) = mn.indices.foldLeft((0L, Long.MaxValue)) {
      case ((bs, b), i) =>
        val j = (i + 1) % n

        (bs + (mn(j).h - mn(i).e).max(0L), b.min(mn(j).h min mn(i).e))
    }

    val ans = bs + b

    println(ans)
  }
}
