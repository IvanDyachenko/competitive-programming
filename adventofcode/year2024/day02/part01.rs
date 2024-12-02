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
        .all(|d| d.abs() <= 3 && d.signum() == ((arr[0] as isize) - (arr[1] as isize)).signum())
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
        .filter(|xs| is_safe(xs))
        .count();

    println!("{}", answer);
}
