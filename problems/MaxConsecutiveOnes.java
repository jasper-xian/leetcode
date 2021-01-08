/*
Given a binary array, find the maximum number of consecutive 1s in this array.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                int x=1;
                for (int j=i+1; j<nums.length; j++) {
                    if (nums[j]==1)
                        x++;
                    else
                        break;
                }
                if (x>max)
                    max = x;
            }
        }
        return max;
    }
}
