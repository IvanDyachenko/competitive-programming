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
                    'X' => {
                        let horizontal = [(i, j), (i, j + 1), (i, j + 2), (i, j + 3)];
                        let count = count + self.is_xmas(horizontal);
                        let horizontal = [(i, j), (i, j - 1), (i, j - 2), (i, j - 3)];
                        let count = count + self.is_xmas(horizontal);

                        let vertical = [(i, j), (i + 1, j), (i + 2, j), (i + 3, j)];
                        let count = count + self.is_xmas(vertical);
                        let vertical = [(i, j), (i - 1, j), (i - 2, j), (i - 3, j)];
                        let count = count + self.is_xmas(vertical);

                        let diagonal = [(i, j), (i + 1, j + 1), (i + 2, j + 2), (i + 3, j + 3)];
                        let count = count + self.is_xmas(diagonal);
                        let diagonal = [(i, j), (i - 1, j - 1), (i - 2, j - 2), (i - 3, j - 3)];
                        let count = count + self.is_xmas(diagonal);
                        let diagonal = [(i, j), (i - 1, j + 1), (i - 2, j + 2), (i - 3, j + 3)];
                        let count = count + self.is_xmas(diagonal);
                        let diagonal = [(i, j), (i + 1, j - 1), (i + 2, j - 2), (i + 3, j - 3)];
                        let count = count + self.is_xmas(diagonal);

                        count
                    }
                    _ => count,
                })
        })
    }

    fn is_xmas(&self, coords: [(usize, usize); 4]) -> usize {
        let result = "XMAS".char_indices().all(|(index, expected)| {
            let actual = *self
                .grid
                .get(coords[index].0)
                .and_then(|xs| xs.get(coords[index].1))
                .unwrap_or(&'~');
            actual == expected
        });
        if result {
            1
        } else {
            0
        }
    }
}

fn main() {
    let text = std::fs::read_to_string("input.txt").unwrap();
    let grid = Grid::parse(&text);
    let answer = grid.xmas();
    println!("{:?}", answer);
}
