pub struct Grid {
    grid: Vec<Vec<char>>,
}

impl Grid {
    pub fn parse(text: &str) -> Self {
        let grid = text
            .split("\n")
            .map(|l| l.trim().chars().collect())
            .collect::<Vec<Vec<char>>>();

        Grid { grid }
    }

    pub fn xmas(&self) -> usize {
        self.grid.iter().enumerate().fold(0, |count, (i, chars)| {
            chars
                .iter()
                .enumerate()
                .fold(count, |count, (j, char)| match char {
                    'A' => {
                        let diagonal = [(i - 1, j - 1), (i, j), (i + 1, j + 1)];
                        let left = self.is_mas(diagonal);
                        let diagonal = [(i + 1, j + 1), (i, j), (i - 1, j - 1)];
                        let left = left || self.is_mas(diagonal);

                        let diagonal = [(i + 1, j - 1), (i, j), (i - 1, j + 1)];
                        let right = self.is_mas(diagonal);
                        let diagonal = [(i - 1, j + 1), (i, j), (i + 1, j - 1)];
                        let right = right || self.is_mas(diagonal);

                        if left && right {
                            count + 1
                        } else {
                            count
                        }
                    }
                    _ => count,
                })
        })
    }

    fn is_mas(&self, coords: [(usize, usize); 3]) -> bool {
        "MAS".char_indices().all(|(index, expected)| {
            let actual = *self
                .grid
                .get(coords[index].0)
                .and_then(|xs| xs.get(coords[index].1))
                .unwrap_or(&'~');
            actual == expected
        })
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let grid = Grid::parse(&text);
    let answer = grid.xmas();
    println!("{:?}", answer);
}
