/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i=0; i<s.length(); i++) {
            String curr1 = s.substring(i, i+1);
            String curr2 = t.substring(i, i+1);
            if (map.containsKey(curr1) && map.get(curr1).equals(curr2))
                continue;
            if (map.containsKey(curr1) && !map.get(curr1).equals(curr2))
                return false;
            if (map.containsValue(curr2))
                return false;
            map.put(curr1, curr2);
        }
        return true;
    }
}
