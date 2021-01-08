/*
Given two arrays, write a function to compute their intersection.

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i=0; i<nums1.length; i++) {
            int curr = nums1[i];
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            }
            else {
                map.put(curr, map.get(curr)+1);
            }
        }
        
        for (int i=0; i<nums2.length; i++) {
            int curr = nums2[i];
            if (map.containsKey(curr) && map.get(curr) > 0) {
                list.add(curr);
                map.put(curr, map.get(curr)-1);
            }
        }
        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
