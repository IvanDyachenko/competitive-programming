use regex::Regex;
use std::{
    fs::File,
    io::{BufRead, BufReader},
};

fn main() {
    let file = File::open("input.txt").unwrap();
    let reader = BufReader::new(file);

    let re = Regex::new(r"mul\((?P<a>\d{1,3}),(?P<b>\d{1,3})\)|do(n't)?\(\)").unwrap();
    let answer = reader
        .lines()
        .fold((0, 1), |(result, enabled), line| {
            re.captures_iter(&line.unwrap())
                .fold((result, enabled), |(result, enabled), c| {
                    match c.get(0).unwrap().as_str() {
                        "do()" => (result, 1),
                        "don't()" => (result, 0),
                        _ => {
                            let a = c.name("a").unwrap().as_str().parse::<usize>().unwrap();
                            let b = c.name("b").unwrap().as_str().parse::<usize>().unwrap();
                            (result + a * b * enabled, enabled)
                        }
                    }
                })
        })
        .0;

    println!("{}", answer);
}
