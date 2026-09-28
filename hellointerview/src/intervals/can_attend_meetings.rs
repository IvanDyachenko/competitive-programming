// https://www.hellointerview.com/learn/code/intervals/can-attend-meetings

pub fn can_attend_meetings(mut intervals: Vec<Vec<i32>>) -> bool {
    if intervals.is_empty() {
        return true;
    }

    intervals.sort_by(|a, b| a[0].cmp(&b[0]));

    for i in 1..intervals.len() {
        if intervals[i][0] < intervals[i - 1][1] {
            return false;
        }
    }

    true
}

#[cfg(test)]
mod tests {
    use super::can_attend_meetings;

    #[test]
    fn overlapping_meetings() {
        let intervals = vec![vec![1, 5], vec![3, 9], vec![6, 8]];
        assert!(!can_attend_meetings(intervals));
    }

    #[test]
    fn non_overlapping_meetings() {
        let intervals = vec![vec![10, 12], vec![6, 9], vec![13, 15]];
        assert!(can_attend_meetings(intervals));
    }

    #[test]
    fn meetings_touch_at_endpoint() {
        let intervals = vec![vec![0, 5], vec![5, 10]];
        assert!(can_attend_meetings(intervals));
    }
}
