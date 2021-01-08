/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
*/

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> s = new Stack();
        int count = 0;
        
        while (count < tokens.length) {
            String curr = tokens[count];
            if (curr.equals("+")) {
                int x = Integer.parseInt(s.pop());
                int y = Integer.parseInt(s.pop());
                s.push(Integer.toString(x+y));
            }
            else if (curr.equals("-")) {
                int x = Integer.parseInt(s.pop());
                int y = Integer.parseInt(s.pop());
                s.push(Integer.toString(y-x));
            }
            else if (curr.equals("*")) {
                int x = Integer.parseInt(s.pop());
                int y = Integer.parseInt(s.pop());
                s.push(Integer.toString(x*y));
            }
            else if (curr.equals("/")) {
                int x = Integer.parseInt(s.pop());
                int y = Integer.parseInt(s.pop());
                s.push(Integer.toString(y/x));
            }
            else {
                s.push(curr);
            }
            count++;
        }
        return Integer.parseInt(s.peek());
        
    }
}
