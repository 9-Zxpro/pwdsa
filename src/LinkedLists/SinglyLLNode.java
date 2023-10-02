package LinkedLists;

public class SinglyLLNode {
    private int data;
    private SinglyLLNode next;
    public SinglyLLNode(int data){
        this.data=data;
    }
    public void setData(int data){
        this.data = data;
    }
    public void setNext(SinglyLLNode node){
        this.next = node;
    }
    public int getData(){
        return this.data;
    }
    public SinglyLLNode getNext(){
        return this.next;
    }
}
