/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

class Solution {
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int num = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num += go(grid, i, j);
                }
            }
        }       
        return num;
    }
    
    public int go(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        
        go(grid, i-1, j);
        go(grid, i+1, j);
        go(grid, i, j-1);
        go(grid, i, j+1);
        
        return 1;
    }
}
