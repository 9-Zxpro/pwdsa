package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
//    Node root;

    public static void display(Node root) {
        if(root!=null) {
            display(root.left);
            System.out.print(root.val+" ");
            display(root.right);
        }
    }

    public static int size(Node root) {
        if(root==null) return 0;
        return     1 + size(root.left) + size(root.right);
    }
    public static int height(Node root) {
        if(root == null || (root.left==null && root.right==null)) return 0;
        return     1 + Math.max(height(root.left), height(root.right));

//        if(root == null) return 0;
//        int lefth = height(root.left);
//        int righth = height(root.right);
//        if(lefth==-1 || righth==-1) return -1;
//        if(Math.abs(lefth-righth) > 1)  return -1;
//        return Math.max(lefth, righth) + 1;

    }
    public static int sum(Node root) {
        if(root==null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }
    public static int max(Node root) {
        if(root==null) return Integer.MIN_VALUE;
        return Math.max(root.val, Math.max(max(root.left), max(root.right)));
    }

    public static void pip(int v){
        if(v==0) return;
        System.out.println(v);
        pip(v-1);
        System.out.println(v);
        pip(v-1);
        System.out.println(v);
    }

    public static void nthLevelTraverse(Node root, int n) {
        if(root==null) return;
        if (n==1){
            System.out.print(root.val+ " ");
            return;
        }
        nthLevelTraverse(root.left, n-1);
        nthLevelTraverse(root.right, n-1);

    }
    public static void bfsTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while (!q.isEmpty()){
            Node tmp = q.peek();
            if(tmp.left!=null) q.add(tmp.left);
            if(tmp.right!=null) q.add(tmp.right);
            System.out.println(tmp.val);
            q.remove();
        }
    }

    public static Node constructTree(String[] arr) {
        int x = Integer.parseInt(arr[0]);
        int n = arr.length;
        Node root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while(i<n-1) {
            Node tmp = q.remove();
            Node left;
            Node right;
            if(arr[i].equals("")){
                left = null;
            } else {
                left = new Node(Integer.parseInt(arr[i]));
                q.add(left);
            }
            if(arr[i+1].equals("")){
                right = null;
            } else {
                right = new Node(Integer.parseInt(arr[i+1]));
                q.add(right);
            }

            tmp.left = left;
            tmp.right = right;
            i = i+2;
        }
        return root;
    }
    public static void main(String[] arg) {
        String[] trees = {"1", "2","3","4", "5", "", "6", "","7","","","8","","","","9",""};
        Node rootOfTree  = constructTree(trees);
//        boundary(rootOfTree);
        nthLevelTraverse(rootOfTree, 2);
//        display(root);
//        System.out.println(size(root));
//        System.out.println(sum(root));
//        System.out.println(max(root));
//        System.out.println(height(root));
//        pip(2);
//        bfsTraverse(rootOfTree);
    }

    private static void boundary(Node root) {
        leftboundary(root);
        bottomboundary(root);
        rightboundary(root.right);
    }

    private static void rightboundary(Node root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        if(root.right!=null) rightboundary(root.right);
        else rightboundary(root.left);
        System.out.print(root.val+" ");
    }

    private static void bottomboundary(Node root) {
        if(root==null) return;
        if(root.left==null && root.right==null) {
            System.out.print(root.val+" ");
            return;
        }
        bottomboundary(root.left);
        bottomboundary(root.right);
    }

    private static void leftboundary(Node root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        System.out.print(root.val+" ");
        if(root.left!=null) leftboundary(root.left);
        else leftboundary(root.right);
    }


}
