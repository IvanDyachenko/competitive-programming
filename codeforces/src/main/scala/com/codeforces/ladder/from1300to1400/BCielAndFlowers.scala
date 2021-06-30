package com.codeforces.ladder.from1300to1400

/** B. Ciel and Flowers
  * https://codeforces.com/problemset/problem/322/B
  */
object BCielAndFlowers extends App {
  import scala.io.StdIn._

  val flowers = readLine().split(" ").map(_.toInt)

  val ans = (0 to 2.min(flowers.min)).map { mixingBouquet =>
    flowers.foldLeft(mixingBouquet) { case (count, flower) =>
      count + 0.max(flower - mixingBouquet) / 3
    }
  }.max

  println(ans)
}
