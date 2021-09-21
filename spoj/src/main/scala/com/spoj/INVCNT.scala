package com.spoj

/** INVCNT - Inversion Count
  * https://www.spoj.com/problems/INVCNT/
  */
object INVCNT extends App {
  import scala.reflect.ClassTag

  implicit final class ArrayOps[A: ClassTag](private val an: Array[A]) {

    def numberOfInversions[B >: A](implicit ord: Ordering[B]): Long = {
      val bn = an.clone()

      def merge(from: Int, middle: Int, until: Int, temp: Array[A]): Long =
        if (ord.lteq(bn(middle - 1), bn(middle))) 0L
        else {
          (from until middle).foreach { i => temp(i - from) = bn(i) }

          (from until until)
            .foldLeft((0L, 0, middle)) {
              case ((c, l, r), i) if l < middle - from && r < until =>
                if (ord.lteq(temp(l), bn(r))) {
                  bn(i) = temp(l)
                  (c, l + 1, r)
                } else {
                  bn(i) = bn(r)
                  (c + middle - from - l, l, r + 1)
                }
              case ((c, l, r), i) if l < middle - from              =>
                bn(i) = temp(l)
                (c, l + 1, r)
              case ((c, l, r), i)                                   =>
                bn(i) = bn(r)
                (c, l, r + 1)
            }
            ._1
        }

      def count(from: Int, until: Int, temporary: Array[A] = null): Long =
        if (from + 1 >= until) 0L
        else {
          val middle = (from + until) >>> 1
          val temp   = if (temporary eq null) new Array[A](until - from) else temporary
          val left   = count(from, middle, temp)
          val right  = count(middle, until, temp)

          left + right + merge(from, middle, until, temp)
        }

      count(0, an.length)
    }

  }

  import InOut._

  val t = nextInt()

  (0 until t).foreach { _ =>
    val n  = nextInt()
    val an = nextInts(n)

    out.println(an.numberOfInversions)
    out.flush()
  }

  final object InOut {
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

    def nextToken(): String = {
      while (tokenizer == null || !tokenizer.hasMoreTokens())
        tokenizer = new java.util.StringTokenizer(in.readLine())
      tokenizer.nextToken()
    }
  }

}

// trait Group[A] {
//   def zero: A
//   def combine(x: A, y: A): A
//   def inverse(x: A): A
// }

// class Fenwick[A: ClassTag](private val n: Int)(implicit g: Group[A]) {
//   private val bits: Array[A] = Array.fill((Integer.highestOneBit(n) << 1) + 1)(g.zero)
//   private val size: Int      = bits.length

//   def update(i: Int, delta: A): Unit =
//     if (i < size) {
//       bits(i) = g.combine(bits(i), delta)
//       update(i + Integer.lowestOneBit(i), delta)
//     }

//   def query(to: Int): A = {
//     @annotation.tailrec
//     def go(i: Int, a: A): A =
//       if (i == 0) a
//       else go(i - Integer.lowestOneBit(i), g.combine(a, bits(i)))
//     go(to, g.zero)
//   }

//   def query(from: Int, to: Int): A =
//     g.combine(query(to), g.inverse(query(from - 1)))
// }

// implicit lazy val IntSummationGroup = new Group[Int] {
//   val zero: Int                    = 0
//   def combine(x: Int, y: Int): Int = x + y
//   def inverse(x: Int): Int         = -x
// }
