/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            String key = this.sort(strs[i]);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
                map.get(key).add(strs[i]);
            }
            else {
                map.get(key).add(strs[i]);
            }
        }
        
        List<List<String>> result = new ArrayList<List<String>>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
    
    public String sort(String s) {
        char[] list = s.toCharArray();
        Arrays.sort(list);
        return new String(list);
    }
}
