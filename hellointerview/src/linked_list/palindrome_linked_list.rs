// https://www.hellointerview.com/learn/code/linked-list/palindrome-linked-list

pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

pub fn is_palindrome(_head: Option<Box<ListNode>>) -> bool {
    todo!()
}

/*
#[cfg(test)]
mod tests {
    use super::{ListNode, is_palindrome};

    fn list(values: &[i32]) -> Option<Box<ListNode>> {
        values.iter().rev().fold(None, |next, &val| {
            Some(Box::new(ListNode { val, next }))
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
