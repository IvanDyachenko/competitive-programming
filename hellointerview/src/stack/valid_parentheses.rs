// https://www.hellointerview.com/learn/code/stack/valid-parentheses

use std::collections::HashMap;

pub fn is_valid(s: String) -> bool {
    let mut stack = Vec::new();

    let mut close2open = HashMap::new();
    close2open.insert(')', '(');
    close2open.insert('}', '{');
    close2open.insert(']', '[');

    for char in s.chars() {
        if let Some(&open) = close2open.get(&char) {
            if stack.pop() != Some(open) {
                return false;
            }
        } else {
            stack.push(char);
        }
    }

    stack.is_empty()
}

#[cfg(test)]
mod tests {
    use super::is_valid;

    #[test]
    fn valid_nested_parentheses() {
        assert!(is_valid("(){({})}".to_string()));
    }

    #[test]
    fn invalid_nested_parentheses() {
        assert!(!is_valid("(){({}})".to_string()));
    }
}
