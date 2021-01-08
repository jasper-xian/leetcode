/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> visited = new HashSet();
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                char curr = board[i][j];
                if (curr != '.') {
                    if (visited.contains(curr + " row " + i) || visited.contains(curr + " column " + j) || visited.contains(curr + " square "  + i/3 + "-" + j/3))
                        return false;
                    visited.add(curr + " row " + i);
                    visited.add(curr + " column " + j);
                    visited.add(curr + " square "  + i/3 + "-" + j/3);
                }
            }
        }
        return true;
    }
}
