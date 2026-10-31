// https://www.hellointerview.com/learn/code/linked-list/linked-list-cycle

// Each next points to an index in nodes; None marks the end of the list.
pub struct ListNode {
    pub val: i32,
    pub next: Option<usize>,
}

pub fn has_cycle(_nodes: &[ListNode], _head: Option<usize>) -> bool {
    todo!()
}

/*
#[cfg(test)]
mod tests {
    use super::{ListNode, has_cycle};

    #[test]
    fn empty_list_has_no_cycle() {
        assert!(!has_cycle(&[], None));
    }

    #[test]
    fn single_node_with_cycle() {
        let nodes = [ListNode { val: 1, next: Some(0) }];
        assert!(has_cycle(&nodes, Some(0)));
    }

    #[test]
    fn single_node_without_cycle() {
        let nodes = [ListNode { val: 1, next: None }];
        assert!(!has_cycle(&nodes, Some(0)));
    }
}
*/
