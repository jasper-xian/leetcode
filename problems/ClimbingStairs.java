/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

class Solution {
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int climbStairs(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n==1 || n==2 || n==3)
            return n;
        else {
            int result = climbStairs(n-1) + climbStairs(n-2);
            map.put(n, result);
            return result;
        }
    }
}
