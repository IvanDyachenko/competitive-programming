package com.codeforces.round85edu

/**
  * C. Circle of Monsters
  * https://codeforces.com/contest/1334/problem/C
  */
object C extends App {
  case class Monster(health: Int, explosion: Int)

  private def bullets(ms: List[Monster]): Int = ???

  val t = scala.io.StdIn.readInt()

  val input = (0 until t).foldLeft(List.empty[List[Monster]]) { (in, _) =>
    val n = scala.io.StdIn.readInt()

    val ms = (0 until n)
      .foldLeft(List.empty[Monster]) { (ms, _) =>
        val Array(h, e) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        Monster(h, e) :: ms
      }
      .reverse

    ms :: in
  }

  val output = input.map(bullets)

  println(output.mkString("\n"))
}
