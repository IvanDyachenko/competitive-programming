package com.codeforces.round85edu

/** A. Level Statistics
  * - https://codeforces.com/contest/1334/problem/A
  */
object A extends App {
  case class Stat(p: Int, c: Int)

  implicit def arr2stat(arr: Array[Int]): Stat = arr match {
    case Array(p, c) => Stat(p, c)
    case _           => throw new IllegalArgumentException
  }

  private def isCorrect(s: Stat): Boolean = s.p >= s.c

  private def isCorrect(s1: Stat, s2: Stat): Boolean =
    isCorrect(s1) && isCorrect(s2) &&
      s1.p <= s2.p && s1.c <= s2.c && (s2.c - s1.c) <= (s2.p - s1.p)

  @scala.annotation.tailrec
  private def isCorrect(stats: List[Stat]): Boolean = stats match {
    case Nil              => true
    case s :: Nil         => isCorrect(s)
    case s1 :: s2 :: rest => isCorrect(s1, s2) && isCorrect(s2 :: rest)
  }

  val t = scala.io.StdIn.readInt()

  val stats = (0 until t)
    .foldLeft(List.empty[List[Stat]]) { (acc1, _) =>
      val n = scala.io.StdIn.readInt()

      val ss = (0 until n)
        .foldLeft(List.empty[Stat]) { (acc2, _) =>
          val s = scala.io.StdIn.readLine().split(" ").map(_.toInt)
          s :: acc2
        }
        .reverse

      ss :: acc1
    }
    .reverse

  val answers = stats.map(isCorrect)

  answers.foreach(if (_) println("YES") else println("NO"))
}
