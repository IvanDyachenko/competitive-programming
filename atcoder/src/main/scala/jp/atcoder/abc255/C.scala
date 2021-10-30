package jp.atcoder.abc255.C

/** C - Calendar Validator
  * https://atcoder.jp/contests/abc225/tasks/abc225_c
  */
object Main extends App {
  type Matrix = Array[Array[Int]]

  def calendarValidator(calendar: Matrix): Boolean = {
    val (rows, columns) = (calendar.length, calendar.headOption.map(_.length).getOrElse(0))

    val (rowShift, columnShift) = calendar.headOption
      .flatMap(_.headOption)
      .map { entry => ((entry - 1) / 7, (entry - 1) % 7) }
      .getOrElse((0, 0))

    calendar.flatten.zipWithIndex.forall { case (entry, index) =>
      val (row, column) = (index / columns, index % columns)

      (rowShift + row) == (entry - 1) / 7 && (columnShift + column) == (entry - 1) % 7
    }

  }

  import InOut._

  val n        = nextInt()
  val m        = nextInt()
  val calendar = Array.fill(n)(nextInts(m))

  calendarValidator(calendar) match {
    case true  => out.println("Yes")
    case false => out.println("No")
  }
  out.flush()

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
