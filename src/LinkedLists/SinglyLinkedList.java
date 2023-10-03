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
    public void addNodeAtBeg(int data) {
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(this.head == null) {
            this.head = this.tail = newNode;
        } else {
            newNode.setNext(head);
            this.head = newNode;
        }
    }

    public SinglyLLNode search(int data) {
        SinglyLLNode tmp = this.head;
        while (tmp != null) {
            if(tmp.getData() == data) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }
    public void addNodeBefore(int data, int beforeNodeData) {
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(this.head == null) {
            this.head = this.tail = newNode;
        } else {
            SinglyLLNode preTemp, tmp = this.head;
            while (tmp != null) {
                preTemp = tmp;
                if (this.head.getData() == beforeNodeData){
                    newNode.setNext(this.head);
                    this.head = newNode;
                    break;
                }
                else if (tmp.getData() == beforeNodeData) {
                    newNode.setNext(tmp.getNext());
                    preTemp.setNext(newNode);
                    break;
                }
                tmp = tmp.getNext();
            }
            if(tmp == null) System.out.println(beforeNodeData + "not found ");
        }
    }
    public void addNodeAfter(int data, int afterNode) {
        SinglyLLNode newNode = new SinglyLLNode(data);
        if(this.head == null) {
            this.head = this.tail = newNode;
        } else {
            SinglyLLNode tmp = search(afterNode);
            if(tmp != null){
                System.out.println(tmp.getData());
                newNode.setNext(tmp.getNext());
                tmp.setNext(newNode);
                if(tmp == this.tail) {
                    this.tail = newNode;
                }
            }
            else System.out.println(afterNode + "not found ");
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
