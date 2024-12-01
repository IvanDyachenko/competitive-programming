use std::{
    collections::HashMap,
    fs::File,
    io::{BufRead, BufReader},
};

fn main() {
    let file = File::open("input.txt").unwrap();
    let reader = BufReader::new(file);

    let (ls, rs): (Vec<isize>, HashMap<isize, usize>) =
        reader
            .lines()
            .fold((Vec::new(), HashMap::new()), |(mut ls, mut rs), line| {
                let line = line.unwrap();
                let (left, right) = line.split_once("   ").unwrap();
                let left = left.trim().parse::<isize>().unwrap();
                let right = right.trim().parse::<isize>().unwrap();
                ls.push(left);
                rs.entry(right).and_modify(|c| *c += 1).or_insert(1);
                (ls, rs)
            });

    let answer: usize = ls.iter().fold(0, |acc, x| {
        acc + rs.get(x).map_or(0, |c| (*x as usize) * *c)
    });

    println!("{:?}", answer);
}
