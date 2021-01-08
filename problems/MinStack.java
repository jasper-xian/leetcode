/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
*/

class MinStack {
    
    class Node {
        int min, val;
        Node next;
        
        public Node(int x, int y) {
            this.val = x;
            this.min = y;
            this.next = null;
        }
    }
    
    Node head;
    
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (head == null)
            head = new Node(x, x);
        else {
            Node temp = new Node(x, Math.min(x, head.min));
            temp.next = head;
            head = temp;
        }
    }
    
    public void pop() {
        Node temp = head.next;
        head.next = null;
        head = temp;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}
