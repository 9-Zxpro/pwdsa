package LinkedLists;

public class SinglyLinkedList {
    private SinglyLLNode head;
    private SinglyLLNode tail;
    public SinglyLLNode getHead(){
        return this.head;
    }
    public SinglyLLNode getTail(){
        return this.tail;
    }

    public void addNodeAtEnd(int data) {
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(this.head == null) {
            this.head = this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }
    public void display() {
        SinglyLLNode tmp = this.head;
        while(tmp != null) {
            if (this.head == null)
                System.out.println("Singly ll is empty.");
            System.out.print(tmp.getData() + "->");
            tmp = tmp.getNext();
        }
        System.out.print("null");
    }
}
