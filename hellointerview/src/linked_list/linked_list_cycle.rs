// https://www.hellointerview.com/learn/code/linked-list/linked-list-cycle

pub struct ListNode {
    pub val: i32,
    pub next: *mut ListNode,
}

pub struct Solution;

impl Solution {
    #[allow(unsafe_code)]
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
    fn single_node_without_cycle() {
        let mut node = ListNode { val: 1, next: ptr::null_mut() };
        assert!(!Solution::has_cycle(&raw mut node));
    }

    #[test]
    fn single_node_with_cycle() {
        let mut node = ListNode { val: 1, next: ptr::null_mut() };
        node.next = &raw mut node;
        assert!(Solution::has_cycle(&raw mut node));
    }

    #[test]
    fn multiple_nodes_without_cycle() {
        let mut third = ListNode { val: 1, next: ptr::null_mut() };
        let mut second = ListNode { val: 1, next: &raw mut third };
        let mut first = ListNode { val: 1, next: &raw mut second };
        assert!(!Solution::has_cycle(&raw mut first));
    }

    #[test]
    fn multiple_nodes_with_cycle() {
        let mut second = ListNode { val: 2, next: ptr::null_mut() };
        let mut third = ListNode { val: 0, next: &raw mut second };
        second.next = &raw mut third;
        let mut first = ListNode { val: 3, next: &raw mut second };
        assert!(Solution::has_cycle(&raw mut first));
    }
}
*/
