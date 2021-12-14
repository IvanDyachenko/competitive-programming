package com.codeforces.edu.disjoint_sets_union.step1

/** A. Disjoint Sets Union
  * - https://codeforces.com/edu/course/2/lesson/7/1/practice/contest/289390/problem/A
  */
object A extends App {

  object immutable {
    final case class DSU[A] private (parents: Map[A, A], ranks: Map[A, Int]) {
      def get(a: A): Option[(A, DSU[A])] = parents.get(a).flatMap {
        case p if a == p => Some((p, this))
        case r           => get(r).map { case (p, DSU(ps, rs)) => (p, DSU(ps.updated(a, p), rs)) }
      }

      def union(a1: A, a2: A): Option[DSU[A]] =
        for {
          (p1, p2, dsu) <- parents(a1, a2) if p1 != p2
          (r1, r2)      <- dsu.ranks(p1, p2)
        } yield (r1 compare r2) match {
          case sign if sign < 0 => DSU(parents.updated(p1, p2), ranks)
          case sign if sign > 0 => DSU(parents.updated(p2, p1), ranks)
          case _                => DSU(parents.updated(p2, p1), ranks.updated(p1, r1 + 1))
        }

      private def ranks(a1: A, a2: A): Option[(Int, Int)] =
        for {
          r1 <- ranks.get(a1)
          r2 <- ranks.get(a2)
        } yield (r1, r2)

      private def parents(a1: A, a2: A): Option[(A, A, DSU[A])] =
        for {
          (p1, dsu) <- get(a1)
          (p2, dsu) <- dsu.get(a2)
        } yield (p1, p2, dsu)
    }

    object DSU {
      def apply[A](as: Set[A]): DSU[A] = {
        val ranks   = (as zip Stream.continually(1)).toMap
        val parents = (as zip as).toMap
        DSU(parents, ranks)
      }
    }
  }

  object mutable {
    import scala.collection.mutable.Map

    final case class DSU[A] private (parents: Map[A, A], ranks: Map[A, Int]) {
      def get(a: A): Option[A] = parents.get(a).flatMap {
        case p if a == p => Some(p)
        case r           => get(r).map { p => parents.update(a, p); p }
      }

      def union(a1: A, a2: A): Unit =
        for {
          (p1, p2) <- parents(a1, a2) if p1 != p2
          (r1, r2) <- ranks(p1, p2)
        } yield (r1 compare r2) match {
          case sign if sign < 0 => parents.update(p1, p2)
          case sign if sign > 0 => parents.update(p2, p1)
          case _                =>
            parents.update(p2, p1)
            ranks.update(p1, r1 + 1)
        }

      private def ranks(a1: A, a2: A): Option[(Int, Int)] =
        for {
          r1 <- ranks.get(a1)
          r2 <- ranks.get(a2)
        } yield (r1, r2)

      private def parents(a1: A, a2: A): Option[(A, A)] =
        for {
          p1 <- get(a1)
          p2 <- get(a2)
        } yield (p1, p2)
    }

    object DSU {
      def apply[A](as: Set[A]): DSU[A] = {
        val ranks   = Map(as.toSeq.map(_ -> 1): _*)
        val parents = Map(as.toSeq.map(a => a -> a): _*)
        DSU(parents, ranks)
      }
    }
  }

  import InOut._

  val n = nextInt()
  val m = nextInt()

  val dsu = mutable.DSU((1 to n).toSet)

  (0 until m).foreach { _ =>
    val command = nextLine().split(" ")

    command match {
      case Array("get", u, v)   =>
        for {
          pu    <- dsu.get(u.toInt)
          pv    <- dsu.get(v.toInt)
          answer = if (pu == pv) "YES" else "NO"
        } out.println(answer)
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
