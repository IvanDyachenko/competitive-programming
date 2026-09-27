package com.leetcode.problems.easy

import munit.FunSuite

class MeetingRoomsSuite extends FunSuite {
  test("overlapping meetings") {
    val intervals = Array(Array(1, 5), Array(3, 9), Array(6, 8))
    assertEquals(MeetingRooms.canAttendMeetings(intervals), false)
  }

  test("non-overlapping meetings") {
    val intervals = Array(Array(10, 12), Array(6, 9), Array(13, 15))
    assertEquals(MeetingRooms.canAttendMeetings(intervals), true)
  }

  test("meetings touch at endpoint") {
    val intervals = Array(Array(0, 5), Array(5, 10))
    assertEquals(MeetingRooms.canAttendMeetings(intervals), true)
  }
}
