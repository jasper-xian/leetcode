/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
*/

import java.util.Arrays;
class Solution {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for (int i=m; i<nums1.length; i++) {
            if (j<n) {
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
        return nums1;
    }
}
