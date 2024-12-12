use std::{
    cmp::max,
    collections::{HashMap, HashSet},
};

#[derive(Debug)]
pub struct Map {
    width: usize,
    height: usize,
    antennas: HashMap<char, HashSet<(usize, usize)>>,
}

impl Map {
    pub fn parse(text: &str) -> Self {
        let (mut width, mut height) = (0, 0);
        let mut antennas = HashMap::new();

        text.split("\n")
            .filter(|l| !l.is_empty())
            .enumerate()
            .for_each(|(y, cs)| {
                height = max(y, height);
                cs.char_indices().for_each(|(x, c)| {
                    width = max(x, width);
                    if c != '.' {
                        antennas.entry(c).or_insert(HashSet::new()).insert((x, y));
                    }
                })
            });

        Map {
            width,
            height,
            antennas,
        }
    }

    pub fn antinodes(&self) -> HashSet<(usize, usize)> {
        let mut antinodes = HashSet::new();
        let (width, height) = (self.width as isize, self.height as isize);

        self.antennas.values().for_each(|points| {
            for (px, py) in points.iter() {
                let (px, py) = (*px, *py);

                for (qx, qy) in points.iter() {
                    let (qx, qy) = (*qx, *qy);

                    if px == qx && py == qy {
                        continue;
                    }

                    let dx = px as isize - qx as isize;
                    let dy = py as isize - qy as isize;

                    let k = max(width / dx, height / dy);

                    let mut x = qx as isize - k * dx;
                    let mut y = qy as isize - k * dy;

                    for _ in 1..(2 * k) {
                        x += dx;
                        y += dy;
                        if x >= 0 && x <= width && y >= 0 && y <= height {
                            antinodes.insert((x as usize, y as usize));
                        }
                    }
                }
            }
        });

        antinodes
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let map = Map::parse(&text);
    let antinodes = map.antinodes();

    let answer = antinodes.len();
    println!("{}", answer);
}
