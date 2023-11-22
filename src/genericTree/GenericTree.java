package genericTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    List<Node> child;

    Node(int val) {
        this.val = val;
        child = new ArrayList<>();
    }
}
public class GenericTree {

    static void formTree(Node root){
        root.child.add(new Node(2));
        root.child.add(new Node(3));
        root.child.add(new Node(4));
        Node child1 = root.child.get(0);
        child1.child.add(new Node(5));
        child1.child.add(new Node(6));
        Node child2 = root.child.get(1);
        child2.child.add(new Node(3));
        child2.child.add(new Node(8));
        child2.child.add(new Node(9));
        Node child3 = root.child.get(2);
        child3.child.add(new Node(8));
    }

    static void preOrdTraverse(Node root) {
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        for(int i=0; i<root.child.size(); i++) {
            preOrdTraverse(root.child.get(i));
        }
    }
    static void postOrdTraverse(Node root) {
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        for(int i=0; i<root.child.size(); i++) {
            postOrdTraverse(root.child.get(i));
        }
        System.out.print(root.val+" ");
    }

    static int findMax(Node root) {
        if(root.child.isEmpty()){
            return root.val;
        }
        for(int i=0; i<root.child.size(); i++) {
            postOrdTraverse(root.child.get(i));
        }
        return 0;
    }

    static void levelOrdTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.val+" ");
            int l = n.child.size();
            for(int i=0; i<l; i++){
                q.offer(n.child.get(i));
            }
        }
    }

    static void mirror(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.val+" ");
            int l = n.child.size();
            for(int i=0; i<l; i++){
                q.offer(n.child.get(i));
            }
        }
    }

    static void zigzagTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.val+" ");
            int l = n.child.size();
            for(int i=0; i<l; i++){
                q.offer(n.child.get(i));
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        formTree(root);
        preOrdTraverse(root);
        System.out.println();
        postOrdTraverse(root);
        System.out.println();
        levelOrdTraverse(root);
    }
}
