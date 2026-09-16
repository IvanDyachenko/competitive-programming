// https://www.hellointerview.com/learn/code/two-pointers/3-sum

pub fn three_sum(_numbers: Vec<i32>) -> Vec<Vec<i32>> {
    todo!()
}

#[cfg(test)]
mod tests {
    use super::three_sum;

    #[test]
    fn hellointerview_example() {
        let mut actual = three_sum(vec![-1, 0, 1, 2, -1, -1]);
        let expected = vec![vec![-1, -1, 2], vec![-1, 0, 1]];

        for triplet in &mut actual {
            triplet.sort_unstable();
        }
        actual.sort_unstable();

        assert_eq!(actual, expected);
    }

    #[test]
    fn leetcode_example_1() {
        let mut actual = three_sum(vec![-1, 0, 1, 2, -1, -4]);
        let expected = vec![vec![-1, -1, 2], vec![-1, 0, 1]];

        for triplet in &mut actual {
            triplet.sort_unstable();
        }
        actual.sort_unstable();

        assert_eq!(actual, expected);
    }

    #[test]
    fn leetcode_example_2() {
        let mut actual = three_sum(vec![0, 1, 1]);
        let expected = Vec::<Vec<i32>>::new();

        for triplet in &mut actual {
            triplet.sort_unstable();
        }
        actual.sort_unstable();

        assert_eq!(actual, expected);
    }

    #[test]
    fn leetcode_example_3() {
        let mut actual = three_sum(vec![0, 0, 0]);
        let expected = vec![vec![0, 0, 0]];

        for triplet in &mut actual {
            triplet.sort_unstable();
        }
        actual.sort_unstable();

        assert_eq!(actual, expected);
    }
}
