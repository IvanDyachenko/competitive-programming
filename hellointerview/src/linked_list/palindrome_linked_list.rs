// https://www.hellointerview.com/learn/code/linked-list/palindrome-linked-list

use super::Link;

pub fn is_palindrome(_head: Link) -> bool {
    todo!()
}

/*
#[cfg(test)]
mod tests {
    use super::is_palindrome;
    use crate::linked_list::{Link, ListNode};
    use std::cell::RefCell;
    use std::rc::Rc;

    fn list(values: &[i32]) -> Link {
        values.iter().rev().fold(None, |next, &val| {
            Some(Rc::new(RefCell::new(ListNode { val, next })))
        })
    }

    #[test]
    fn palindrome() {
        assert!(is_palindrome(list(&[5, 4, 3, 4, 5])));
    }

    #[test]
    fn not_palindrome() {
        assert!(!is_palindrome(list(&[5, 4, 3])));
    }

    #[test]
    fn empty_list_is_palindrome() {
        assert!(is_palindrome(None));
    }
}
*/
