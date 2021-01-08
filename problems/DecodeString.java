/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
*/

class Solution {
    public String decodeString(String str) {
        int index = 0;
        Stack<String> s = new Stack();
        ArrayList<String> numList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8",                                                                           "9", "0"));
        
        while (index < str.length()) {
            String curr = str.substring(index, index + 1);
            if (curr.equals("]")) {
                List<String> list = new ArrayList<String>();
                while (!s.peek().equals("[")) {
                    list.add(0, s.pop());
                }
                s.pop();
                String numbers = "";
                while (!s.isEmpty() && numList.contains(s.peek())) {
                    numbers = s.pop() + "" + numbers;
                }
                int num = Integer.parseInt(numbers);
                for (int i=0; i<num; i++) {
                    for (int j=0; j<list.size(); j++) {
                        s.push(list.get(j));
                    }
                }
            }
            else {
                s.push(curr);
            }
            index++;
        }
        
        String output = "";
        while (!s.isEmpty()) {
            output = s.pop() + "" + output;
        }
        return output;
    }
}
