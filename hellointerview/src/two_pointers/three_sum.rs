// https://www.hellointerview.com/learn/code/two-pointers/3-sum

pub fn three_sum(mut ns: Vec<i32>) -> Vec<Vec<i32>> {
    ns.sort_unstable();
    let len = ns.len();

    let mut rs = Vec::new();

    for i in 0..len {
        if i > 0 && ns[i] == ns[i - 1] {
            continue;
        }

        let (mut l, mut r) = (i + 1, len - 1);

        while l < r && ns[i] <= 0 {
            let s = ns[i] + ns[l] + ns[r];

            if s < 0 {
                l += 1;
            } else if s > 0 {
                r -= 1;
            } else {
                rs.push(vec![ns[i], ns[l], ns[r]]);

                while l < r && ns[l] == ns[l + 1] {
                    l += 1;
                }

                while l < r && ns[r] == ns[r - 1] {
                    r -= 1;
                }

                l += 1;
                r -= 1;
            }
        }
    }

    rs
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
