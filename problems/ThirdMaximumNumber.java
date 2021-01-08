/*
Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
*/

import java.util.Arrays;
class Solution {
    public int thirdMax(int[] nums) {
        if (this.numDistinct(nums) < 3) {
            Arrays.sort(nums);
            return nums[nums.length-1];
        }   
        else {
            Arrays.sort(nums); int c=1;
            for (int i=nums.length-2; i>=0; i--) {
                if (nums[i] != nums[i+1])
                    c++;
                if (c == 3)
                    return nums[i];
            }
            return -1;
        }
    }
    
    public int numDistinct(int[] nums) {
        Arrays.sort(nums); int c=1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] != nums[i])
                c++;
        }
        return c;
    }
}
