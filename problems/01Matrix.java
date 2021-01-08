/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/

class Solution {
    
    class Pair {
        int x, y;
        
        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                newMatrix[i][j] = nearestZero(matrix, i, j);
            }
        }
        return newMatrix;
    }
    
    public int nearestZero(int[][] matrix, int r, int c) {
        //HashSet<ArrayList<Integer>> visited = new HashSet();
        Queue<Pair> q = new LinkedList();
        int count = 0;
        q.offer(new Pair(r, c));
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Pair curr = q.poll();
                if (curr.x < 0 || curr.y < 0 || curr.x >= matrix.length || curr.y >= matrix[0].length) {
                    size--;
                    continue;
                }
                if (matrix[curr.x][curr.y] == 0)
                    return count;
                
                q.offer(new Pair(curr.x+1, curr.y));
                q.offer(new Pair(curr.x-1, curr.y));
                q.offer(new Pair(curr.x, curr.y+1));
                q.offer(new Pair(curr.x, curr.y-1)); 
                size--;
            }
            count++;
        }
        return -1;
    }
}
