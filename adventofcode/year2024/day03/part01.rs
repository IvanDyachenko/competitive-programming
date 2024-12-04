use regex::Regex;
use std::{
    fs::File,
    io::{BufRead, BufReader},
};

fn main() {
    let file = File::open("input.txt").unwrap();
    let reader = BufReader::new(file);

    let regex = Regex::new(r"mul\((\d{1,3}),(\d{1,3})\)").unwrap();
    let answer = reader.lines().fold(0, |result, line| {
        regex
            .captures_iter(&line.unwrap())
            .map(|c| c.extract())
            .fold(result, |result, (_, [a, b])| {
                result + a.parse::<isize>().unwrap() * b.parse::<isize>().unwrap()
            })
    });

    println!("{}", answer);
}
