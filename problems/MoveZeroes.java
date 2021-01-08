/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int c=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]==0)
                c++;
            else {
                nums[i-c] = nums[i];
            }
        }
        for (int i=0; i<c; i++)
            nums[nums.length-i-1] = 0;
    }
}
