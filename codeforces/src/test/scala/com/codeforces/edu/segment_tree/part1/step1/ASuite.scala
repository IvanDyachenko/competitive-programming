package com.codeforces.edu.segment_tree.part1.step1

import munit.{FunSuite, ScalaCheckSuite}
import org.scalacheck.{Prop, Gen}
import A._

class ASuite extends FunSuite with ScalaCheckSuite {

  test("ITMO Academy | Segment Tree | Part 1 | Step 1 | A | 1 test case") {
    val as = Array(1, 2, 3, 4, 5)
    val st = new SegmentTree[Int](as)

    assertEquals(st.query(0, 4), 15)
    assertEquals(st.query(0, 3), 10)
    assertEquals(st.query(0, 2), 6)
    assertEquals(st.query(0, 1), 3)
    assertEquals(st.query(0, 0), 1)

    assertEquals(st.query(1, 4), 14)
    assertEquals(st.query(1, 3), 9)
    assertEquals(st.query(1, 2), 5)
    assertEquals(st.query(1, 1), 2)

    assertEquals(st.query(2, 4), 12)
    assertEquals(st.query(2, 3), 7)
    assertEquals(st.query(2, 2), 3)

    assertEquals(st.query(3, 4), 9)
    assertEquals(st.query(3, 3), 4)

    assertEquals(st.query(4, 4), 5)
  }

  property("ITMO Academy | Segment Tree | Part 1 | Step 1 | A | 1 property") {
    Prop.forAll { (as: Array[Int]) =>
      val st = new SegmentTree[Int](as)
      as.indices.foreach { i => assertEquals(st.query(i, i), as(i)) }
    }
  }

}
