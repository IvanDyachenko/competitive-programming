package com.csacademy.task

/** Classic Task
  * https://csacademy.com/contest/archive/task/classic-task/statement/
  */
object ClassicTask extends App {

  sealed trait Move
  final case object Down  extends Move { override def toString(): String = "D" }
  final case object Right extends Move { override def toString(): String = "R" }

  type Matrix = Array[Array[Long]]

  implicit final class MatrixOps(private val matrix: Matrix) extends AnyVal {

    def hirschberg: List[Move] = {
      val (n, m) = (matrix.length, matrix.headOption.map(_.length).getOrElse(0))

      val edit = Array.fill(2, m)(-1L)
      val half = Array.fill(2, m)(-1)

      def go(left: (Int, Int), right: (Int, Int)): List[Move] = {

        val (leftRow, leftColumn)   = left
        val (rightRow, rightColumn) = right

        if (leftRow == rightRow)
          List.fill(rightColumn - leftColumn)(Right) ++ (if (rightRow != n - 1) List(Down) else Nil)
        else {
          val middleRow = (leftRow + rightRow) >> 1

          for {
            row     <- leftRow to rightRow
            column  <- leftColumn to rightColumn
            cost     = matrix(row)(column)
            current  = row & 1
            previous = current ^ 1

          } {

            edit(current)(column) = cost + (row match {
              case row if leftRow == row =>
                if (leftColumn == column) 0L else edit(current)(column - 1)
              case _                     =>
                val top = edit(previous)(column)

                if (leftColumn == column) top
                else {
                  val left = edit(current)(column - 1)
                  top min left
                }
            })

            half(current)(column) = row match {
              case row if row < middleRow  => -1
              case row if row == middleRow => column - leftColumn
              case row if row > middleRow  =>
                column match {
                  case column if leftColumn == column => half(previous)(column)
                  case _                              =>
                    edit(current)(column) match {
                      case value if value - cost == edit(previous)(column)    => half(previous)(column)
                      case value if value - cost == edit(current)(column - 1) => half(current)(column - 1)
                    }
                }
            }

          }

          val middleColumn = leftColumn + half(rightRow & 1)(rightColumn)

          go(left, (middleRow, middleColumn)) ++ go((middleRow + 1, middleColumn), right)
        }
      }

      go((0, 0), (n - 1, m - 1))
    }

  }

  import InOut._

  val n  = nextInt()
  val m  = nextInt()
  val un = nextLongs(n)
  val vm = nextLongs(m)

  val matrix: Matrix = Array.fill(n, m)(0L)
  (0 until n).foreach { i =>
    (0 until m).foreach { j =>
      matrix(i)(j) = (un(i) + j + 1) ^ (vm(j) + i + 1)
    }
  }

  out.println(matrix.hirschberg.mkString(""))
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
