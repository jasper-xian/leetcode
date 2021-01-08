/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
You may assume the string contains only lowercase English letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if (s.length() == 0)
            return -1;
        
        for (int i=0; i<s.length(); i++) {
            String curr = s.substring(i, i+1);
            if (!map.containsKey(curr)) {
                map.put(curr, 1);
            }
            else {
                map.replace(curr, map.get(curr)+1);
            }
        }
        for (int i=0; i<s.length(); i++) {
            String curr = s.substring(i, i+1);
            if (map.containsKey(curr) && map.get(curr) == 1)
                return i;
        }
        return -1;
    }
}
