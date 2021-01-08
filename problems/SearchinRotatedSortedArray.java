/*
You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.
*/

class Solution {
    public int search(int[] nums, int target) {
        int pivot = nums[0];
        int index = -1;
        if (target == pivot)
            return 0;
        if (nums.length == 1) {
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1])
                index = i+1;
        }
        
        int left, right;
        if (index == -1) {
            left = 0;
            right = nums.length-1;
        }
        else if (target < pivot) {
            left = index;
            right = nums.length-1;
        }
        else {
            left = 0;
            right = index;
        }
        
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}
