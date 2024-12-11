use core::panic;

#[derive(Debug)]
pub struct Equation {
    value: usize,
    numbers: Vec<usize>,
}

impl Equation {
    pub fn parse(text: &str) -> Vec<Self> {
        text.split("\n")
            .filter(|l| !l.is_empty())
            .map(|l| {
                let all: Vec<usize> = l
                    .split([':', ' '])
                    .filter_map(|x| x.parse::<usize>().ok())
                    .rev()
                    .collect();

                match all.as_slice() {
                    [numbers @ .., value] => Equation {
                        value: *value,
                        numbers: numbers.to_vec(),
                    },
                    _ => panic!(),
                }
            })
            .collect()
    }

    pub fn is_possible(&self) -> bool {
        evaluate(self.value, &self.numbers)
    }
}

fn evaluate(value: usize, numbers: &[usize]) -> bool {
    match numbers {
        [number] => value == *number,
        [number, numbers @ ..] => {
            let substraction = value as isize - *number as isize;
            let substraction = if substraction < 0 {
                false
            } else {
                evaluate(substraction as usize, numbers)
            };

            let division = value % *number;
            let division = if division != 0 {
                false
            } else {
                evaluate(value / *number, numbers)
            };

            let unconcat = {
                let (value_str, number_str) = (value.to_string(), number.to_string());
                if value_str.len() > number_str.len() && value_str.ends_with(&number_str) {
                    let value = value_str[..value_str.len() - number_str.len()]
                        .parse::<usize>()
                        .unwrap();
                    evaluate(value, numbers)
                } else {
                    false
                }
            };

            substraction || division || unconcat
        }
        _ => false,
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let equations = Equation::parse(&text);

    let answer = equations.iter().fold(0, |result, equation| {
        if equation.is_possible() {
            result + equation.value
        } else {
            result
        }
    });

    println!("{:?}", answer);
}
