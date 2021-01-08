/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
Given n, calculate F(n).
*/

import java.util.HashMap;
class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int fib(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n<2)
            return n;
        int result = fib(n-1) + fib(n-2);
        map.put(n, result);
        return result;
    }
}
