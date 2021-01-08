/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            if (map.containsKey(curr) && Math.abs(map.get(curr) - i) <= k)
                return true;
            else
                map.put(curr, i);
        }
        return false;
    }
}
