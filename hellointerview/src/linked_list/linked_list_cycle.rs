// https://www.hellointerview.com/learn/code/linked-list/linked-list-cycle

use super::Link;

pub fn has_cycle(_head: Link) -> bool {
    todo!()
}

/*
#[cfg(test)]
mod tests {
    use super::has_cycle;
    use crate::linked_list::ListNode;
    use std::cell::RefCell;
    use std::rc::Rc;

    #[test]
    fn empty_list_has_no_cycle() {
        assert!(!has_cycle(None));
    }

    #[test]
    fn single_node_with_cycle() {
        let node = Rc::new(RefCell::new(ListNode { val: 1, next: None }));
        node.borrow_mut().next = Some(Rc::clone(&node));

        let actual = has_cycle(Some(Rc::clone(&node)));
        node.borrow_mut().next = None;
        assert!(actual);
    }

    #[test]
    fn single_node_without_cycle() {
        let node = Rc::new(RefCell::new(ListNode { val: 1, next: None }));
        assert!(!has_cycle(Some(node)));
    }
}
*/
