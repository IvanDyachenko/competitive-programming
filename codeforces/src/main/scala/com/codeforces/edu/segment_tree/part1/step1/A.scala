package com.codeforces.edu.segment_tree.part1.step1

/** A. Segment Tree for the Sum
  * https://codeforces.com/edu/course/2/lesson/4/1/practice/contest/273169/problem/A
  */
object A extends App {
  import scala.reflect.ClassTag

  trait Monoid[A] {
    def zero: A
    def combine(a1: A, a2: A): A
  }

  object Monoid {
    implicit val intSummationMonoid: Monoid[Int] = new Monoid[Int] {
      val zero: Int                      = 0
      def combine(a1: Int, a2: Int): Int = a1 + a2
    }

    implicit val longSummationMonoid: Monoid[Long] = new Monoid[Long] {
      val zero: Long                        = 0L
      def combine(a1: Long, a2: Long): Long = a1 + a2
    }
  }

  final class SegmentTree[A: ClassTag](private val as: Iterable[A])(implicit m: Monoid[A]) {

    private val height: Int =
      as.isEmpty match {
        case true => -1
        case _    =>
          val lteq = 31 - Integer.numberOfLeadingZeros(as.size)
          val size = 1 << lteq
          lteq + (if (size == as.size) 0 else 1)
      }

    private val nodes: Int =
      as.isEmpty match {
        case true => 0
        case _    => (1 << (height + 1)) - 1
      }

    private val leaves: Int =
      as.isEmpty match {
        case true => 0
        case _    => 1 << height
      }

    private val nonleaves: Int = nodes - leaves

    private val data: Array[A] = {
      val data = Array.fill(nodes)(m.zero)

      as.copyToArray(data, nonleaves)

      (nonleaves - 1).to(0, -1).foreach { i =>
        val j = 2 * i + 1
        data(i) = m.combine(data(j), data(j + 1))
      }

      data
    }

    def query(from: Int, to: Int): A = {
      require(from >= 0, "The left bound of the range should be no less than 0")
      require(to < leaves, s"The right bound of the range should be less than $leaves")
      require(from <= to, "The left bound of the range should be no more than the right bound of that range")

      @annotation.tailrec
      def go(left: Int, right: Int, result: A): A =
        if (left > right) result
        else {
          val addition = m.combine(
            if (left  % 2 == 0) data(left) else m.zero,
            if (right % 2 == 0) m.zero else data(right)
          )

          go(left >> 1, (right >> 1) - 1, m.combine(result, addition))
        }

      go(nonleaves + from, nonleaves + to, m.zero)
    }

    def update(index: Int, element: A): Unit = {
      require(0 <= index && index < leaves, s"The index should be in the range [0, $leaves)")

      data(nonleaves + index) = element

      height.until(0, -1).foldLeft(nonleaves + index) { (i, _) =>
        val j = (i - 1) >> 1
        data(j) = m.combine(data(i), data(if (i % 2 == 0) i - 1 else i + 1))
        j
      }
    }
  }

  import InOut._

  val n  = nextInt()
  val m  = nextInt()
  val an = nextLongs(n)

  val st = new SegmentTree(an)

  (0 until m).foreach { _ =>
    nextInt() match {
      case 1 =>
        val i = nextInt()
        val v = nextLong()
        st.update(i, v)
      case 2 =>
        val l = nextInt()
        val r = nextInt()
        val q = st.query(l, r - 1)
        out.println(q)
    }
  }

  out.flush()

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
