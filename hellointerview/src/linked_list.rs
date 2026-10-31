use std::cell::RefCell;
use std::rc::Rc;

pub mod linked_list_cycle;
pub mod palindrome_linked_list;

pub type Link = Option<Rc<RefCell<ListNode>>>;

pub struct ListNode {
    pub val: i32,
    pub next: Link,
}
