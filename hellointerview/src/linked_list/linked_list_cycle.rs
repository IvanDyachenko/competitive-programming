// https://www.hellointerview.com/learn/code/linked-list/linked-list-cycle

pub struct ListNode {
    pub val: i32,
    pub next: *mut ListNode,
}

pub struct Solution;

impl Solution {
    pub fn has_cycle(_head: *mut ListNode) -> bool {
        todo!()
    }
}

/*
#[cfg(test)]
mod tests {
    use super::{ListNode, Solution};
    use std::ptr;

    #[test]
    fn empty_list_has_no_cycle() {
        assert!(!Solution::has_cycle(ptr::null_mut()));
    }

    #[test]
    fn single_node_with_cycle() {
        let mut node = Box::new(ListNode { val: 1, next: ptr::null_mut() });
        let head: *mut ListNode = &mut *node;
        node.next = head;
        assert!(Solution::has_cycle(head));
    }

    #[test]
    fn single_node_without_cycle() {
        let mut node = Box::new(ListNode { val: 1, next: ptr::null_mut() });
        assert!(!Solution::has_cycle(&mut *node));
    }
}
*/
