/*
Given an array nums of integers, return how many of them contain an even number of digits.
*/

class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        
        for (int i=0; i<nums.length; i++) {
            int d=0;
            int x = nums[i];
            do {
                x = x/10;
                d++;
            }
            while (x>0);
            if (d%2==0)
                c++;
        }
        return c;
    }
}
