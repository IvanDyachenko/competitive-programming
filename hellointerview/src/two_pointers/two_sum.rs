// https://www.hellointerview.com/learn/code/two-pointers/two-sum

use std::cmp::Ordering::{Equal, Greater, Less};

pub fn two_sum(numbers: Vec<i32>, target: i32) -> bool {
    if numbers.len() < 2 {
        return false;
    }

    let (mut left, mut right) = (0, numbers.len() - 1);

    while left < right {
        match (numbers[left] + numbers[right]).cmp(&target) {
            Less => left += 1,
            Equal => return true,
            Greater => right -= 1,
        }
    }

    false
}

#[cfg(test)]
mod tests {
    use super::two_sum;

    #[test]
    fn leetcode_example_1() {
        let actual = two_sum(vec![2, 7, 11, 15], 9);

        assert!(actual);
    }

    #[test]
    fn leetcode_example_2() {
        let actual = two_sum(vec![2, 3, 4], 6);

        assert!(actual);
    }

    #[test]
    fn leetcode_example_3() {
        let actual = two_sum(vec![-1, 0], -1);

        assert!(actual);
    }

    #[test]
    fn hellointerview_example_1() {
        let actual = two_sum(vec![1, 3, 4, 6, 8, 10, 13], 13);

        assert!(actual);
    }

    #[test]
    fn hellointerview_example_2() {
        let actual = two_sum(vec![1, 3, 4, 6, 8, 10, 13], 6);

        assert!(!actual);
    }

    #[test]
    fn equal_values_at_distinct_indices() {
        let actual = two_sum(vec![3, 3], 6);

        assert!(actual);
    }

    #[test]
    fn single_element_cannot_form_a_pair() {
        let actual = two_sum(vec![3], 6);

        assert!(!actual);
    }

    #[test]
    fn empty_array_has_no_pair() {
        let actual = two_sum(vec![], 0);

        assert!(!actual);
    }
}
