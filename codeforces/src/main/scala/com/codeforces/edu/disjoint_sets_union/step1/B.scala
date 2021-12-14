package com.codeforces.edu.disjoint_sets_union.step1

/** B. Disjoint Sets Union 2
  * - https://codeforces.com/edu/course/2/lesson/7/1/practice/contest/289390/problem/B
  */
object B extends App {
  import scala.collection.mutable.Map

  trait Monoid[A] {
    def zero: A
    def combine(a1: A, a2: A): A
  }

  object Monoid {
    type MinMaxCount = (Int, Int, Int)

    implicit val MinMaxCountMonoid = new Monoid[MinMaxCount] {
      val zero: MinMaxCount                         = (Int.MaxValue, Int.MinValue, 0)
      def combine(a1: MinMaxCount, a2: MinMaxCount) = (a1._1 min a2._1, a1._2 max a2._2, a1._3 + a2._3)
    }
  }

  final case class DSU[A, B] private (parents: Map[A, A], values: Map[A, B], ranks: Map[A, Int])(implicit
      m: Monoid[B]
  ) {
    def get(a: A): Option[(A, B)] = parents.get(a).flatMap {
      case p if a == p => values.get(p).map(p -> _)
      case r           => get(r).map { case result @ (p, _) => parents.update(a, p); result }
    }

    def union(a1: A, a2: A): Unit =
      for {
        (p1, v1) <- get(a1)
        (p2, v2) <- get(a2)
        if p1 != p2
        (r1, r2) <- ranks(p1, p2)
        v         = m.combine(v1, v2)
      } (r1 compare r2) match {
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
      val seq     = values.toSeq
      val ranks   = Map(seq.map { case (a, _) => a -> 1 }: _*)
      val parents = Map(seq.map { case (a, _) => a -> a }: _*)
      DSU(parents, values, ranks)
    }
  }

  import InOut._

  val n = nextInt()
  val m = nextInt()

  val dsu = {
    val as = (1 to n).map(a => a -> (a, a, 1))
    DSU(Map(as: _*))
  }

  (0 until m).foreach { _ =>
    val command = nextLine().split(" ")

    command match {
      case Array("get", u)      =>
        for {
          (_, (min, max, count)) <- dsu.get(u.toInt)
        } out.println(s"$min $max $count")
      case Array("union", u, v) => dsu.union(u.toInt, v.toInt)
    }
  }
  out.flush()

  object InOut {
    import java.util.Scanner

    val in  = new java.io.BufferedReader(new java.io.InputStreamReader(System.in))
    val out = new java.io.PrintWriter(System.out, false)

    def nextInt()        = Integer.parseInt(nextToken())
    def nextInts(n: Int) = Array.fill(n)(nextInt())

    def nextLong()        = java.lang.Long.parseLong(nextToken())
    def nextLongs(n: Int) = Array.fill(n)(nextLong())

    def nextBig()        = BigInt(nextToken())
    def nextBigs(n: Int) = Array.fill(n)(nextBig())

    def nextLine() = in.readLine()

    private[this] var tokenizer: java.util.StringTokenizer = _

    private[this] def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }
}
