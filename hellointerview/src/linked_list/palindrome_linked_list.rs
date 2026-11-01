// https://www.hellointerview.com/learn/code/linked-list/palindrome-linked-list

pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

pub struct Solution;

impl Solution {
    pub fn is_palindrome(_head: Option<Box<ListNode>>) -> bool {
        todo!()
    }
}

/*
#[cfg(test)]
mod tests {
    use super::{ListNode, Solution};

    fn list(values: &[i32]) -> Option<Box<ListNode>> {
        values.iter().rev().fold(None, |next, &val| {
            Some(Box::new(ListNode { val, next }))
        })
    }

    #[test]
    fn palindrome() {
        assert!(Solution::is_palindrome(list(&[5, 4, 3, 4, 5])));
    }

    #[test]
    fn not_palindrome() {
        assert!(!Solution::is_palindrome(list(&[5, 4, 3])));
    }

    #[test]
    fn empty_list_is_palindrome() {
        assert!(Solution::is_palindrome(None));
    }

    #[test]
    fn single_node_is_palindrome() {
        assert!(Solution::is_palindrome(list(&[5])));
    }

    #[test]
    fn even_length_palindrome() {
        assert!(Solution::is_palindrome(list(&[1, 2, 2, 1])));
    }

    #[test]
    fn even_length_not_palindrome() {
        assert!(!Solution::is_palindrome(list(&[1, 2])));
    }
}
*/
