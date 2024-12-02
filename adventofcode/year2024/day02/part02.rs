use std::{
    fs::File,
    io::{BufRead, BufReader},
};

fn is_safe(arr: &[usize]) -> bool {
    arr.windows(2)
        .map(|pair| match pair {
            [x, y] => (*x as isize) - (*y as isize),
            _ => 0,
        })
        .all(|d| {
            d.signum() == ((arr[0] as isize) - (arr[1] as isize)).signum()
                && d.abs() >= 1
                && d.abs() <= 3
        })
}

fn main() {
    let file = File::open("input.txt").unwrap();
    let reader = BufReader::new(file);

    let answer: usize = reader
        .lines()
        .map(|l| {
            l.unwrap()
                .split_ascii_whitespace()
                .flat_map(str::parse::<usize>)
                .collect::<Vec<_>>()
        })
        .filter(|xs| {
            (0..xs.len()).any(|i| {
                let mut ys = xs.clone();
                ys.remove(i);
                is_safe(&ys)
            })
        })
        .count();

    println!("{}", answer);
}
