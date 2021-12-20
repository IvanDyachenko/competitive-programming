package com.codeforces.contest.round762div3

/** B. Squares and Cubes
  * https://codeforces.com/contest/1619/problem/B
  */
object B extends App {
  val Upper = 1e9.toLong

  val squares = Stream
    .unfold(1L) { number =>
      val square = number * number
      Option.when(square <= Upper)(square -> (number + 1))
    }
    .toArray

  val cubes = Stream
    .unfold(1L) { number =>
      val cube  = number * number * number
      val index = squares.binarySearch(cube)
      Option.when(cube <= Upper)(cube -> (number + 1))
    }
    .filter { cube =>
      val index = squares.binarySearch(cube)
      index == squares.length || cube != squares(index)
    }
    .toArray

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n = nextLong()
    val c = squares.binarySearch(n) + cubes.binarySearch(n) + 2

    out.println(c)
  }
  out.flush()

  implicit final class LongArrayOps(private val xs: Array[Long]) extends AnyVal {
    def binarySearch(x: Long): Int = {
      @annotation.tailrec
      def go(left: Int, right: Int): Int =
        if (left + 1 >= right) left
        else {
          val middle = (left + right) >> 1
          if (xs(middle) <= x) go(middle, right) else go(left, middle)
        }

      go(-1, xs.length)
    }
  }

  object InOut {
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
