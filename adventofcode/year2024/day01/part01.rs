use std::{
    fs::File,
    io::{BufRead, BufReader},
};

fn main() {
    let file = File::open("input.txt").unwrap();
    let reader = BufReader::new(file);

    let (mut ls, mut rs): (Vec<isize>, Vec<isize>) = reader
        .lines()
        .map(|line| {
            let line = line.unwrap();
            let (left, right) = line.split_once("   ").unwrap();
            let left = left.trim().parse::<isize>().unwrap();
            let right = right.trim().parse::<isize>().unwrap();
            (left, right)
        })
        .unzip();
    ls.sort();
    rs.sort();

    let answer: usize = ls
        .iter()
        .zip(rs.iter())
        .fold(0, |acc, (l, &r)| acc + l.abs_diff(r));

    println!("{}", answer);
}
