#[derive(Clone)]
pub struct Map {
    area: Vec<Vec<char>>,
    area_height: usize,
    area_width: usize,
    guard_pos: Option<(usize, usize)>,
    guard_dir_index: usize,
}

impl Map {
    const GUARD_DIRECTIONS: &[(isize, isize); 4] = &[(-1, 0), (0, 1), (1, 0), (0, -1)];

    pub fn parse(text: &str) -> Self {
        let mut guard_pos = None;
        let area: Vec<Vec<char>> = text
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
        let area_height = area.len();
        let area_width = area.first().map_or(0, |xs| xs.len());
        Map {
            area,
            area_height,
            area_width,
            guard_pos,
            guard_dir_index: 0,
        }
    }

    pub fn is_loop(&mut self) -> bool {
        let mut visited = 0;
        while let Some(guard_pos) = self.guard_pos {
            visited += 1;
            if visited >= self.area_height * self.area_width {
                break;
            }

            let (x, y) = guard_pos;
            let (dx, dy) = Map::GUARD_DIRECTIONS[self.guard_dir_index];
            let (x, y) = (x as isize + dx, y as isize + dy);
            if x < 0 || x >= self.area_height as isize {
                self.guard_pos = None;
                continue;
            }
            if y < 0 || y >= self.area_width as isize {
                self.guard_pos = None;
                continue;
            }
            let (x, y) = (x as usize, y as usize);
            if self.area[x][y] == '#' {
                self.guard_dir_index = (self.guard_dir_index + 1) % Map::GUARD_DIRECTIONS.len();
            } else {
                self.guard_pos = Some((x, y));
            }
        }
        self.guard_pos.is_some()
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let map = Map::parse(&text);

    let mut answer = 0;
    for (i, xs) in map.area.iter().enumerate() {
        for (j, x) in xs.iter().enumerate() {
            if Some((i, j)) == map.guard_pos {
                continue;
            }
            if *x == '#' {
                continue;
            }
            let mut map = map.clone();
            map.area[i][j] = '#';
            answer += if map.is_loop() { 1 } else { 0 };
        }
    }

    println!("{}", answer);
}
