// LeetCode #2461: Maximum Sum of Distinct Subarrays With Length K
// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

pub struct Solution;

impl Solution {
    pub fn maximum_subarray_sum(_nums: Vec<i32>, _k: i32) -> i64 {
        todo!()
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn first_example() {
        let actual = Solution::maximum_subarray_sum(vec![1, 5, 4, 2, 9, 9, 9], 3);
        assert_eq!(actual, 15);
    }

    #[test]
    fn second_example() {
        let actual = Solution::maximum_subarray_sum(vec![4, 4, 4], 3);
        assert_eq!(actual, 0);
    }
}
