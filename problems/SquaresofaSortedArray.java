/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*/

import java.util.Arrays;
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] b = new int[A.length];
        for (int i=0; i<b.length; i++) {
            double x = Math.pow(A[i], 2);
            b[i] = (int) x;
        }
        Arrays.sort(b);
        return b;
    }
}
