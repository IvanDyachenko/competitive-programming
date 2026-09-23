// https://www.hellointerview.com/learn/code/two-pointers/move-zeroes
// https://leetcode.com/problems/move-zeroes/

pub fn move_zeroes(ns: &mut [i32]) {
    let mut j = 0;
    for i in 0..ns.len() {
        if ns[i] != 0 {
            ns.swap(j, i);
            j += 1;
        }
    }
}

#[cfg(test)]
mod tests {
    use crate::two_pointers::move_zeroes::move_zeroes;

    #[test]
    fn example_1() {
        let mut ns = vec![2, 0, 4, 0, 9];
        move_zeroes(&mut ns);

        assert_eq!(ns, vec![2, 4, 9, 0, 0]);
    }

    #[test]
    fn example_2() {
        let mut ns = vec![0];
        move_zeroes(&mut ns);

        assert_eq!(ns, vec![0]);
    }

    #[test]
    fn example_3() {
        let mut ns = vec![1];
        move_zeroes(&mut ns);

        assert_eq!(ns, vec![1]);
    }

    #[test]
    fn example_4() {
        let mut ns = vec![0, 1, 0, 3, 12];
        move_zeroes(&mut ns);

        assert_eq!(ns, vec![1, 3, 12, 0, 0]);
    }
}
