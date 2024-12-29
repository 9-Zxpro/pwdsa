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
        }
        if (this.head.getData() == beforeNodeData){     //insertAtBeginning
            newNode.setNext(this.head);
            this.head = newNode;
        }
            SinglyLLNode preTemp = null, tmp = this.head;
            while (tmp != null && tmp.getData() != beforeNodeData) {
                preTemp = tmp;
                tmp = tmp.getNext();
            }
            if(tmp == null) System.out.println(beforeNodeData + "not found ");
            else {
                newNode.setNext(tmp);
                preTemp.setNext(newNode);
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

    public void deleteAtBeg() {
        if (this.head == null) {
            System.out.println("List is empty. Cannot delete.");
        } else {
            this.head = this.head.getNext();
            if (this.head == null) {
                this.tail = null; // List became empty
            }
        }
    }

    public void deleteAtEnd() {
        if (this.head == null) {
            System.out.println("List is empty. Cannot delete.");
        } else if (this.head == this.tail) {
            this.head = this.tail = null; // Single node in the list
        } else {
            SinglyLLNode tmp = this.head;
            while (tmp.getNext() != this.tail) {
                tmp = tmp.getNext();
            }
            tmp.setNext(null);
            this.tail = tmp;
        }
    }

    public void deleteNode(int data) {
        if (this.head == null) {
            System.out.println("List is empty. Cannot delete.");
        } else if (this.head.getData() == data) {
            deleteAtBeg();
        } else {
            SinglyLLNode tmp = this.head, preTemp = null;
            while (tmp != null && tmp.getData() != data) {
                preTemp = tmp;
                tmp = tmp.getNext();
            }
            if (tmp == null) {
                System.out.println(data + " not found in the list.");
            } else {
                preTemp.setNext(tmp.getNext());
                if (tmp == this.tail) {
                    this.tail = preTemp; // Update tail if the deleted node was the last
                }
            }
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
