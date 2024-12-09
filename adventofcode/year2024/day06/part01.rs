pub struct Map {
    area: Vec<Vec<char>>,
    guard_pos: Option<(usize, usize)>,
    guard_dir: usize,
}

impl Map {
    const GUARD_DIRECTIONS: &[(isize, isize); 4] = &[(-1, 0), (0, 1), (1, 0), (0, -1)];

    pub fn parse(text: &str) -> Self {
        let mut guard_pos = None;
        let area = text
            .split("\n")
            .filter(|line| !line.is_empty())
            .enumerate()
            .map(|(i, line)| {
                line.char_indices()
                    .map(|(j, c)| match c {
                        '^' => {
                            guard_pos = Some((i, j));
                            '.'
                        }
                        c => c,
                    })
                    .collect()
            })
            .collect();
        Map {
            area,
            guard_pos,
            guard_dir: 0,
        }
    }

    pub fn patrol(&mut self) -> usize {
        let mut visited =
            vec![vec![false; self.area.first().map_or(0, |xs| xs.len())]; self.area.len()];

        while let Some(guard_pos) = self.guard_pos {
            let (x, y) = guard_pos;
            visited[x][y] = true;
            let (dx, dy) = Map::GUARD_DIRECTIONS[self.guard_dir];
            let (x, y) = (x as isize + dx, y as isize + dy);
            if x < 0 || x >= self.area.len() as isize {
                self.guard_pos = None;
                break;
            }
            if y < 0 || y >= self.area.first().map_or(0, |xs| xs.len()) as isize {
                self.guard_pos = None;
                break;
            }
            let (x, y) = (x as usize, y as usize);
            if self.area[x][y] == '#' {
                self.guard_dir = (self.guard_dir + 1) % Map::GUARD_DIRECTIONS.len();
            } else {
                self.guard_pos = Some((x, y));
            }
        }

        visited.iter().fold(0, |c, xs| {
            xs.iter().fold(c, |c, x| if *x { c + 1 } else { c })
        })
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let mut map = Map::parse(&text);

    let answer = map.patrol();
    println!("{}", answer);
}
