use std::collections::{HashMap, HashSet};

pub struct Rules {
    rules: HashMap<usize, HashSet<usize>>,
}

impl Rules {
    pub fn parse(text: &str) -> Self {
        let rules = text
            .split("\n")
            .filter_map(|l| {
                l.split_once("|").and_then(|(x, y)| {
                    let x = x.parse::<usize>().ok();
                    let y = y.parse::<usize>().ok();
                    match (x, y) {
                        (Some(x), Some(y)) => Some((x, y)),
                        _ => None,
                    }
                })
            })
            .fold(HashMap::new(), |mut map, (x, y)| {
                map.entry(x).or_insert(HashSet::new()).insert(y);
                map
            });
        Rules { rules }
    }

    pub fn is_correct(&self, n: usize, previous: &HashSet<usize>) -> bool {
        self.rules
            .get(&n)
            .map(|xs| xs.iter().all(|x| !previous.contains(x)))
            .unwrap_or(true)
    }
}

pub struct Update {
    numbers: Vec<usize>,
}

impl Update {
    pub fn parse(text: &str) -> Self {
        let numbers = text
            .split(",")
            .filter_map(|n| n.parse::<usize>().ok())
            .collect();
        Update { numbers }
    }

    pub fn is_correct(&self, rules: &Rules) -> bool {
        let (result, _): (bool, HashSet<usize>) =
            self.numbers
                .iter()
                .fold((true, HashSet::new()), |(result, mut previous), n| {
                    let result = result && rules.is_correct(*n, &previous);
                    previous.insert(*n);
                    (result, previous)
                });
        result
    }

    pub fn middle(&self) -> usize {
        self.numbers[self.numbers.len() / 2]
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let (rules_text, updates_text) = text.split_once("\n\n").unwrap();
    let rules = Rules::parse(rules_text);
    let updates = updates_text
        .split("\n")
        .filter(|text| !text.is_empty())
        .map(Update::parse);

    let answer = updates.fold(0, |result, update| match update.is_correct(&rules) {
        true => result + update.middle(),
        _ => result,
    });

    println!("{}", answer);
}
