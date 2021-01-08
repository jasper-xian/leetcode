/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
*/

class Solution {
    public int search(int[] nums, int target) {
        return this.go(nums, target, 0, nums.length-1);
    }
    
    public int go(int[] nums, int target, int left, int right) {
        if (nums[right] == target)
            return right;
        if (nums[left] == target)
            return left;
        
        int mid = left + (right - left) / 2;
        if (mid == left || mid == right)
            return -1;
        
        if (target < nums[mid]) {
            return go(nums, target, left, mid);
        }
        else if (target > nums[mid]) {
            return go(nums, target, mid, right);
        }
        else
            return mid;
        
    }
}
