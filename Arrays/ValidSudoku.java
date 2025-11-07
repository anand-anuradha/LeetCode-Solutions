/*
Problem: Valid Sudoku
Link: https://leetcode.com/problems/valid-sudoku/

Approach:
- We iterate through each cell of the 9x9 board only once.
- For every filled cell (not '.'), we check three conditions:
    1. The value must not already exist in the corresponding row.
    2. The value must not already exist in the corresponding column.
    3. The value must not already exist in the corresponding 3x3 sub-box.
- We maintain three arrays of HashSets:
    - `rows[r]` stores seen values for row r.
    - `cols[c]` stores seen values for column c.
    - `boxes[idx]` stores seen values for sub-box index.
- The sub-box index is computed using:
      (r / 3) * 3 + (c / 3)
  This maps each cell to one of the nine 3x3 boxes correctly.
- If any duplicate is found during checks, return false immediately.
- If we complete traversal without conflicts, return true.

Why this is optimal:
- Time Complexity: O(1), because the board is always 9x9 → we visit 81 cells once.
- Space Complexity: O(1), we only store at most 81 numbers across sets and board size is fixed.
- HashSet enables constant-time lookups, making validation fast and efficient.
*/

package arrays;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}
