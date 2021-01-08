/*
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
*/

class Solution {
    public int mySqrt(int x) {
        long result = (long) x;
        
        while (!(result * result - x < 1))
            result = (result + x / result) / 2;
        
        return (int) result;
    }
}
