package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GNode {
    int val;
    List<GNode> child;

    GNode(int val) {
        this.val = val;
        child = new ArrayList<>();
    }
}
public class GenericTree {

    static void formTree(GNode root){
        root.child.add(new GNode(2));
        root.child.add(new GNode(3));
        root.child.add(new GNode(4));
        GNode child1 = root.child.getFirst();
        child1.child.add(new GNode(5));
        child1.child.add(new GNode(6));
        GNode child2 = root.child.get(1);
        child2.child.add(new GNode(3));
        child2.child.add(new GNode(8));
        child2.child.add(new GNode(9));
        GNode child3 = root.child.get(2);
        child3.child.add(new GNode(8));
    }

    static void preOrdTraverse(GNode root) {
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        System.out.print(root.val+" ");
        for(int i=0; i<root.child.size(); i++) {
            preOrdTraverse(root.child.get(i));
        }
    }
    static void postOrdTraverse(GNode root) {
        if(root.child.isEmpty()){
            System.out.print(root.val+" ");
            return;
        }
        for(int i=0; i<root.child.size(); i++) {
            postOrdTraverse(root.child.get(i));
        }
        System.out.print(root.val+" ");
    }

    static int findMax(GNode root) {
        if(root.child.isEmpty()){
            return root.val;
        }
        for(int i=0; i<root.child.size(); i++) {
            postOrdTraverse(root.child.get(i));
        }
        return 0;
    }

    static void levelOrdTraverse(GNode root) {
        Queue<GNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            GNode n = q.poll();
            System.out.print(n.val+" ");
            int l = n.child.size();
            for(int i=0; i<l; i++){
                q.offer(n.child.get(i));
            }
        }
    }

    static void mirror(GNode root) {
        Queue<GNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            GNode n = q.poll();
            System.out.print(n.val+" ");
            int l = n.child.size();
            for(int i=0; i<l; i++){
                q.offer(n.child.get(i));
            }
        }
    }

    static void zigzagTraverse(GNode root) {
        Queue<GNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            GNode n = q.poll();
            System.out.print(n.val+" ");
            int l = n.child.size();
            for(int i=0; i<l; i++){
                q.offer(n.child.get(i));
            }
        }
    }
    public static void main(String[] args) {
        GNode root = new GNode(1);
        formTree(root);
        preOrdTraverse(root);
        System.out.println();
        postOrdTraverse(root);
        System.out.println();
        levelOrdTraverse(root);
    }
}
