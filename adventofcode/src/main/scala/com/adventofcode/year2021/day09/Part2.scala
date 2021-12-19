package com.adventofcode.year2021.day09

/** Day 9: Smoke Basin. Part 2
  * https://adventofcode.com/2021/day/9#part2
  */
object Part2 extends App {
  import scala.collection.mutable

  trait Monoid[A] {
    def zero: A
    def combine(a1: A, a2: A): A
  }

  final class DSU[A, B] private (
      private val values: mutable.Map[A, B],
      private val parents: mutable.Map[A, A],
      private val ranks: mutable.Map[A, Int]
  )(implicit m: Monoid[B]) {
    def get(a: A): Option[(A, B)] = parents.get(a).flatMap {
      case p if a == p => values.get(p).map(p -> _)
      case r           => get(r).map { case result @ (p, _) => parents.update(a, p); result }
    }

    def union(a1: A, a2: A): Unit =
      for {
        (p1, v1) <- get(a1)
        (p2, v2) <- get(a2)
        (r1, r2) <- ranks(p1, p2) if p1 != p2
        v         = m.combine(v1, v2)
      } yield (r1 compare r2) match {
        case sign if sign < 0 =>
          values.update(p2, v)
          parents.update(p1, p2)
        case sign if sign > 0 =>
          values.update(p1, v)
          parents.update(p2, p1)
        case _                =>
          ranks.update(p1, r1 + 1)
          values.update(p1, v)
          parents.update(p2, p1)
      }

    private def ranks(a1: A, a2: A): Option[(Int, Int)] =
      for {
        r1 <- ranks.get(a1)
        r2 <- ranks.get(a2)
      } yield (r1, r2)
  }

  object DSU {
    def apply[A, B: Monoid](values: Map[A, B]): DSU[A, B] = {
      val ranks   = values.keys.map(_ -> 1).to(mutable.Map)
      val parents = values.keys.map(a => a -> a).to(mutable.Map)
      new DSU(values.to(mutable.Map), parents, ranks)
    }
  }

  final case class Heightmap private (rows: Int, columns: Int, heights: Array[Array[Int]]) {

    lazy val basins: IndexedSeq[Int] = {
      val locations =
        for {
          x <- 0 until rows
          y <- 0 until columns
          h  = heights(x)(y) if h < Heightmap.MaxValue
        } yield (x, y)

      val dsu = DSU(locations.map(_ -> 1).toMap)(Heightmap.SizeMonoid)

      @annotation.tailrec
      def traverse(locations: Seq[(Int, Int)]): Unit = locations match {
        case (location @ (x, y)) +: locations =>
          val lowest = heights(x)(y)

          dsu.get(location) match {
            case Some((root, _)) =>
              val next = neighbors(x, y).collect {
                case neighbor @ (i, j) if heights(i)(j) > lowest && dsu.get(neighbor) != root => neighbor
              }.foldLeft(locations) { (locations, neighbor) =>
                dsu.union(location, neighbor)
                neighbor +: locations
              }
              traverse(next)
            case _               => traverse(locations)
          }
        case _                                =>
      }

      traverse(minimums)

      minimums.map(dsu.get(_).map(_._2)).flatten
    }

    private lazy val minimums: IndexedSeq[(Int, Int)] =
      for {
        x     <- 0 until rows
        y     <- 0 until columns
        height = heights(x)(y) if height != Heightmap.MaxValue
        lowest = neighbors(x, y).map { case (x, y) => heights(x)(y) }.min if height < lowest
      } yield (x, y)

    private def neighbors(i: Int, j: Int): List[(Int, Int)] =
      List(
        Option.when(i > 0)((i - 1)        -> j),
        Option.when(j > 0)(i              -> (j - 1)),
        Option.when(i < rows - 1)((i + 1) -> j),
        Option.when(j < columns - 1)(i    -> (j + 1))
      ).flatten
  }

  object Heightmap {
    val MaxValue = 9

    def fromString(input: Seq[String]): Heightmap = {
      val heights = input.toArray.map(_.split("").map(_.toInt))
      val rows    = heights.length
      val columns = heights.headOption.map(_.length).getOrElse(0)

      require(heights.forall(_.length == columns))

      Heightmap(rows, columns, heights)
    }

    implicit val SizeMonoid = new Monoid[Int] {
      val zero: Int                      = 0
      def combine(a1: Int, a2: Int): Int = a1 + a2
    }
  }

  val source = scala.io.Source.fromResource("year2021/day09/input.txt").getLines().toList

  val heightmap = Heightmap.fromString(source)
  val basins    = heightmap.basins.sorted(Ordering[Int].reverse)
  val answer    = basins.take(3).foldLeft(1L)(_ * _)

  println(s"What do you get if you multiply together the sizes of the three largest basins? $answer")
}
