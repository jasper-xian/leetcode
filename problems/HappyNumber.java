/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
*/

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> visited = new HashSet();
        while (go(n) != 1) {
            if (visited.contains(n))
                return false;
            visited.add(n);
            n = go(n);
        }
        return true;
    }
    
    public int go(int n) {
        int result = 0;
        while (n / 10 != 0) {
            int curr = n % 10;
            result += Math.pow(curr, 2);
            n = n / 10;
        }
        result += Math.pow(n, 2);
        return result;
    }
}
