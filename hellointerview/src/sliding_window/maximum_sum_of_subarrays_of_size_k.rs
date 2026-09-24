// https://www.hellointerview.com/learn/code/sliding-window/maximum-sum-of-subarrays-of-size-k

pub fn max_sum(xs: Vec<i32>, k: i32) -> i32 {
    let mut result = i32::MIN;

    let mut current = 0;
    for (i, x) in xs.iter().enumerate() {
        current += x;
        if i >= k as usize {
            current -= xs[i - k as usize];
        }
        if i >= k as usize - 1 {
            result = result.max(current);
        }
    }

    result
}

#[cfg(test)]
mod tests {
    use crate::sliding_window::maximum_sum_of_subarrays_of_size_k::max_sum;

    #[test]
    fn example_1() {
        let xs = vec![2, 1, 5, 1, 3, 2];

        assert_eq!(max_sum(xs, 3), 9);
    }

    #[test]
    fn example_2() {
        let xs = vec![-1, -2, -3, -4, -5];

        assert_eq!(max_sum(xs, 2), -3);
    }

    #[test]
    fn example_3() {
        let xs = vec![4, 2, 4, 5, 6];

        assert_eq!(max_sum(xs, 4), 17);
    }
}
