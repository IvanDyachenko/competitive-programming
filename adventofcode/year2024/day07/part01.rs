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
                    .collect();

                match all.as_slice() {
                    [value, numbers @ ..] => {
                        let mut numbers = numbers.to_vec();
                        numbers.reverse();
                        Equation {
                            value: *value,
                            numbers,
                        }
                    }
                    _ => panic!(),
                }
            })
            .collect()
    }

    pub fn is_possible(&self) -> bool {
        evaluate(self.value as isize, &self.numbers)
    }
}

fn evaluate(value: isize, numbers: &[usize]) -> bool {
    match numbers {
        [number] => value == *number as isize,
        [number, numbers @ ..] => {
            let substraction = value - *number as isize;
            let substraction = if substraction < 0 {
                false
            } else {
                evaluate(substraction, numbers)
            };

            let division = value % *number as isize;
            let division = if division != 0 {
                false
            } else {
                evaluate(value / *number as isize, numbers)
            };

            substraction || division
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
