package com.codeforces.round632div2

/** A. Little Artem
  * - https://codeforces.com/contest/1333/problem/A
  */
object A extends App {
  case class Size(n: Int, m: Int)

  implicit def arr2size(arr: Array[Int]): Size = arr match {
    case Array(n, m) => Size(n, m)
    case _           => throw new IllegalArgumentException
  }

  private def colorize(s: Size): Seq[Seq[Char]] = {
    val Size(n, m) = s

    for (i <- 0 until n) yield {
      for (j <- 0 until m) yield if (i + j == 0) 'W' else 'B'
    }
  }

//  private def colorize(s: Size): Seq[Seq[Char]] = {
//    val Size(n, m) = s
//
//    if (n > m) colorize(Size(m, n)).transpose
//    else (0 until n).map(i => List.fill(m - i)('B') ::: List.fill(i)('W'))
//  }

  val t = scala.io.StdIn.readInt()

  val sizes = (0 until t)
    .foldLeft(List.empty[Size]) { (acc, _) =>
      val size = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      size :: acc
    }
    .reverse

  val answers = sizes.map(colorize)

  answers.foreach(answer => println(answer.map(_.mkString("")).mkString("\n")))
}
