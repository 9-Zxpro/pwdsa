package stack;

/*
A stack is an Ordered list in which insertion and deletion are done at one end, called top. LIFO
Direct Application -
Balancing of symbols
Infix to postfix conversion
Implementing function calls
Finding of spans
Page-visited history in a web browser
Undo sequence
Matching tags (HTML/XML)
 */

import LinkedLists.SinglyLLNode;


public class Stacks {
    SinglyLLNode head;

/*
static final int MAX = 1000;
int top;
int a[] = new int[MAX]; // Maximum size of Stack

Stacks()
{
    top = -1;
}
 */

    public boolean isEmpty() {
        return head == null;
    }
    public void push(int data) {
        SinglyLLNode newNode = new SinglyLLNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    public int pop() {
        if(head == null) {
            throw new IllegalStateException("Stack Underflow: Cannot pop from an empty stack");
        } else {
            int data = head.getData();
            head = head.getNext();
            return data;
        }
    }

    public int peek() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty: Cannot peek");
        }
        return head.getData();
    }

    public void display() {
        if (head == null) {
            System.out.println("Stack is empty");
        } else {
            SinglyLLNode temp = head;
            System.out.print("Stack contents: ");
            while (temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stacks s = new Stacks();
        s.push(10);
        s.push(20);
        s.push(30);

        s.display();
    }
}

/*
For Array/LinkedList -
Time complexity - For all operations - O(1).
Space complexity - O(n).
 */
