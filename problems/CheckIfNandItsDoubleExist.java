/*
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
*/

class Solution {
    public boolean checkIfExist(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]*2 || nums[j] == nums[i]*2)
                    return true;
            }
        }
        return false;
    }
}
