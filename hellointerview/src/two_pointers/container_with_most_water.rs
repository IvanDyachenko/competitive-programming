// https://www.hellointerview.com/learn/code/two-pointers/container-with-most-water

pub fn max_area(hs: Vec<i32>) -> i32 {
    let mut a = 0;

    let mut l = 0;
    let mut r = hs.len() - 1;

    while l < r {
        a = a.max((r - l) as i32 * hs[l].min(hs[r]));

        if hs[l] < hs[r] {
            l += 1
        } else {
            r -= 1
        };
    }

    a
}

#[cfg(test)]
mod tests {
    use super::max_area;

    #[test]
    fn two_equal_walls() {
        let heights = vec![1, 1];
        assert_eq!(max_area(heights), 1);
    }

    #[test]
    fn mixed_heights() {
        let heights = vec![1, 8, 6, 2, 5, 4, 8, 3, 7];
        assert_eq!(max_area(heights), 49);
    }

    #[test]
    fn zero_heights() {
        let heights = vec![0, 0];
        assert_eq!(max_area(heights), 0);
    }

    #[test]
    fn increasing_heights() {
        let heights = vec![1, 2, 3, 4, 5];
        assert_eq!(max_area(heights), 6);
    }

    #[test]
    fn decreasing_heights() {
        let heights = vec![5, 4, 3, 2, 1];
        assert_eq!(max_area(heights), 6);
    }

    #[test]
    fn maximum_length_and_height() {
        let heights = vec![10_000; 100_000];
        assert_eq!(max_area(heights), 999_990_000);
    }
}
