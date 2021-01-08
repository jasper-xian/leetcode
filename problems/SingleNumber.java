/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
*/

class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        
        for (int i=0; i<nums.length; i++) {
            int curr = nums[i];
            if (set.contains(curr))
                set.remove(curr);
            else
                set.add(curr);
        }
        Iterator iter = set.iterator();
        return (int) iter.next();
    }
}
