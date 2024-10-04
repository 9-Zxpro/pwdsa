package tree;

public class BinarySTree {

    public static void deleteNode(Node root, int val){
        if(root==null) return;
        

    }
    public static void main(String[] args) {
        String[] trees = {"10", "5","15","2","8","12","17"};
        Node root  = BinaryTree.constructTree(trees);
        deleteNode(root, 17);
        BinaryTree.display(root);
    }
}
