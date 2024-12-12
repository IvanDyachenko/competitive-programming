use std::{
    cmp::{max, min},
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
            for (i, (px, py)) in points.iter().enumerate() {
                let (px, py) = (*px, *py);
                for (qx, qy) in points.iter().skip(i + 1) {
                    let (qx, qy) = (*qx, *qy);
                    let dx = px as isize - qx as isize;
                    let dy = py as isize - qy as isize;

                    let ax = qx as isize - dx;
                    let ay = qy as isize - dy;

                    if ax >= 0 && ax <= width && ay >= 0 && ay <= height {
                        antinodes.insert((ax as usize, ay as usize));
                    }

                    let bx = px as isize + dx;
                    let by = py as isize + dy;

                    if bx >= 0 && bx <= width && by >= 0 && by <= height {
                        antinodes.insert((bx as usize, by as usize));
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
