/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.
*/

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int odds=0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]%2==1)
                odds++;
            else {
                int temp = nums[i-odds];
                nums[i-odds] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}
