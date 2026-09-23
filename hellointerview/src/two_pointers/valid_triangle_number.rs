// https://www.hellointerview.com/learn/code/two-pointers/valid-triangle-number

pub fn triangle_number(ns: Vec<i32>) -> i32 {
    let mut xs = ns;
    xs.sort_unstable();

    let mut count: i32 = 0;
    for c in (2..xs.len()).rev() {
        let (mut a, mut b) = (0, c - 1);

        while a < b {
            if xs[a] + xs[b] > xs[c] {
                count += (b - a) as i32;
                b -= 1;
            } else {
                a += 1;
            }
        }
    }
    count
}

#[cfg(test)]
mod tests {
    use crate::two_pointers::valid_triangle_number::triangle_number;

    #[test]
    fn example_1() {
        assert_eq!(triangle_number(vec![2, 2, 3, 4]), 3);
    }

    #[test]
    fn example_2() {
        assert_eq!(triangle_number(vec![4, 2, 4, 3]), 4);
    }

    #[test]
    fn example_3() {
        assert_eq!(triangle_number(vec![11, 4, 9, 6, 15, 18]), 10);
    }
}
