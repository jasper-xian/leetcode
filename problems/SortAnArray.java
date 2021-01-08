/*
Given an array of integers nums, sort the array in ascending order.
*/

class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1)
            return nums;
        int pivot = nums.length / 2;
        int[] a = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] b = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(a, b);
    }
    
    public int[] merge(int[] a, int[] b) {
        int[] list = new int[a.length + b.length];
        int countA = 0, countB = 0, count = 0;
        while (countA < a.length && countB < b.length) {
            if (a[countA] < b[countB]) {
                list[count] = a[countA];
                countA++;
            }
            else {
                list[count] = b[countB];
                countB++;
            }
            count++;
        }
        while (countA < a.length) {
            list[count] = a[countA];
            countA++; count++;
        }
        while (countB < b.length) {
            list[count] = b[countB];
            countB++; count++;
        }
        return list;
    }
}
