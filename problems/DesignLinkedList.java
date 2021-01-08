/*
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
*/

class MyLinkedList {
    
    int length;
    Node head;
    
    class Node {
        int value;
        Node next, prev;
        
        Node(int x) {this.value = x;}
    }

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= this.length || index < 0)
            return -1;
        else {
            Node curr = this.head;
            int c = 0;
            while (c != index) {
                curr = curr.next; c++;
            }
            return curr.value;
        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node x = new Node(val);
        x.next = this.head;
        x.prev = null;
        if (head != null)
            this.head.prev = x;
        this.head = x;
        this.length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.length == 0) {
            this.addAtHead(val);
	    return;
        }
        else {
            Node curr = this.head;
            while (curr.next != null) {
                curr = curr.next;
            }
            Node x = new Node(val);
            curr.next = x;
            x.prev = curr;
            x.next = null;
            this.length++;    
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int value) {
        if(index == this.length) {
            addAtTail(value);
            return;
        }
        if(index > this.length) {
            return;
        }
        if(index == 0){
            addAtHead(value);
            return;
        }
            int c=0; Node curr = this.head;
            while (c < index - 1) {
                curr = curr.next;
                c++;
            }
            Node x = new Node(value);
            x.next = curr.next;
            curr.next = x;
            x.prev = curr;
            if (x.next != null)
                x.next.prev = x;
            this.length++;    
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= this.length || index < 0) {
            return;
        }
        else {
            int c=0; Node curr = this.head; Node pre = null; 
            if (index == 0)
                this.head = curr.next;
            else {
                while (c < index) {
                    pre = curr;
                    curr = curr.next;
                    c++;
                }
                if (curr.next != null) {
                    curr.next.prev = pre;
                    pre.next = curr.next;
                    this.length--; 
                }
                else {
                    pre.next = null;
                    this.length--;
                }
            }
        }
    }
}
