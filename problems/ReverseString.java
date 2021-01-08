/*
Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.
*/

class Solution {
    public void reverseString(char[] s) {
        helper(0, s.length-1, s);
    }
    
    public void helper(int start, int end, char[] s) {
        
        if (start == end || start >= end)
            return;
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(start+1, end-1, s);
    }
}
