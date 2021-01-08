/*
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively.
You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
*/

class MyQueue {
    
    Stack<Integer> stack;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp = new Stack();
        while (stack.size() > 1) {
            temp.push(stack.pop());
        }
        int result = stack.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        Stack<Integer> temp = new Stack();
        while (stack.size() > 1) {
            temp.push(stack.pop());
        }
        int result = stack.peek();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
