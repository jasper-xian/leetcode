/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.
*/

class Solution {
    
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return count;
    }
    
    public void dfs(int[] nums, int S, int sum, int index) {
        if (index == nums.length) {
            if (sum == S)
                count++;
            return;
        }
        dfs(nums, S, sum + nums[index], index+1);
        dfs(nums, S, sum - nums[index], index+1);
    }
}
