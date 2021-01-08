/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/

class Solution {
    public boolean isValid(String s) {
        Stack<String> S = new Stack<String>();
        int count = 0;
        
        if (s.length() % 2 == 1)
            return false;
        
        while (count < s.length()) {
            String curr = s.substring(count, count+1);
            if (curr.equals("(") || curr.equals("[") || curr.equals("{")) {
                S.push(curr);
            }
            else {
                if (S.isEmpty())
                    return false;
                String prev = S.pop();
                if (curr.equals(")") && !prev.equals("("))
                    return false;
                if (curr.equals("]") && !prev.equals("["))
                    return false;
                if (curr.equals("}") && !prev.equals("{"))
                    return false;
            }
            count++;
        }
        return S.isEmpty();
    }
}
