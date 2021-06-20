package com.codeforces.round630div2

/** A. Exercising Walk
  * - http://codeforces.com/contest/1332/problem/A
  */
object A extends App {
  case class Path(a: Int, b: Int, c: Int, d: Int)
  case class Limit(x: Int, y: Int, x1: Int, y1: Int, x2: Int, y2: Int)
  case class Case(path: Path, limit: Limit)

  implicit def array2path(arr: Array[Int]): Path = arr match {
    case Array(a, b, c, d) => Path(a, b, c, d)
    case _                 => throw new IllegalArgumentException
  }

  implicit def array2limit(arr: Array[Int]): Limit = arr match {
    case Array(x, y, x1, y1, x2, y2) => Limit(x, y, x1, y1, x2, y2)
    case _                           => throw new IllegalArgumentException
  }

  private def isSatisfied: PartialFunction[Case, Boolean] = {
    case Case(Path(a, b, c, d), Limit(x, y, x1, y1, x2, y2)) =>
      val dx = b - a
      val dy = d - c

      if (x == x1 && x == x2 && a != 0 && b != 0) false
      else if (y == y1 && y == y2 && d != 0 && c != 0) false
      else
        (dx <= 0 && x + dx >= x1 || dx >= 0 && x + dx <= x2) &&
        (dy <= 0 && y + dy >= y1 || dy >= 0 && y + dy <= y2)
  }

  val t = scala.io.StdIn.readInt()

  val input: List[Case] = (0 until t)
    .foldLeft(List.empty[Case]) { case (cases, _) =>
      val path: Path   = scala.io.StdIn.readLine().split(" ").map(_.toInt)
      val limit: Limit = scala.io.StdIn.readLine().split(" ").map(_.toInt)

      Case(path, limit) :: cases
    }
    .reverse

  val output: List[String] = input.map(isSatisfied).map(if (_) "YES" else "NO")

  output.foreach(println)
}
