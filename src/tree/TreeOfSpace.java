package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TreeOfSpace {
    static class TreeNode{
        String name;
        boolean isLocked;
        int uid;
        TreeNode parent;
        int ancLocked;
        int desLocked;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(String name, TreeNode parent) {
            this.name = name;
            this.parent = parent;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        Map<String, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(br.readLine(), null);
        map.put(root.name, root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ind = 1;

        while (!queue.isEmpty() && ind < n){
            TreeNode parentNode = queue.poll();
            for(int i=0; i<m && ind < n; i++) {
                TreeNode childNode = new TreeNode(br.readLine(), parentNode);
                parentNode.children.add(childNode);
                map.put(childNode.name, childNode);
                queue.add(childNode);
                ind++;
            }
        }

        for(int i=0; i<q; i++) {
            String[] parts = br.readLine().split(" ");
            int operation = Integer.parseInt(parts[0]);
            String nodeName = parts[1];
            int userId = Integer.parseInt(parts[2]);
            boolean answer = false;
            TreeNode node = map.get(nodeName);
            if(operation == 1) {
                answer = lock(node, userId);
            } else if(operation == 2) {
                answer = unlock(node, userId);
            } else if (operation == 3) {
                answer = upgrade(node, userId);
            }
            System.out.println(answer);
        }
        br.close();
    }

    public static boolean lock(TreeNode node, int uid) {
        if(node.isLocked) return false;
        if (node.ancLocked > 0 || node.desLocked > 0) return false;
        TreeNode curr = node.parent;
        while (curr!=null) {
            curr.desLocked+=1;
            curr = curr.parent;
        }
        informDesc(node, 1);
        node.isLocked = true;
        node.uid = uid;
        return true;
    }
    public static boolean unlock(TreeNode node, int uid) {
        if (!node.isLocked || node.uid != uid) return false;
        TreeNode curr = node.parent;
        while (curr!=null) {
            curr.desLocked-=1;
            curr = curr.parent;
        }
        informDesc(node, -1);
        node.isLocked = false;
        node.uid = 0;
        return true;
    }
    public static void informDesc(TreeNode node, int val) {
        if (node == null) return ;
        node.ancLocked+=val;
        for (TreeNode des : node.children) {
            informDesc(des, val);
        }
    }

    public static boolean upgrade(TreeNode node, int uid) {
        if(node.isLocked || node.ancLocked > 0 || node.desLocked == 0) return false;
        List<TreeNode> child = new ArrayList<>();
        boolean res = getAllChild(node, child, uid);
        if (!res) return false;
        for(TreeNode c : child) {
            unlock(c, uid);
        }
        lock(node, uid);
        return true;
    }

    static boolean getAllChild(TreeNode node, List<TreeNode> child, int uid) {
        if(node == null) return true;
        if (node.isLocked) {
            if(node.uid != uid) return false;
            else child.add(node);
        }
        if (node.desLocked == 0) return true;
        for (TreeNode c : node.children) {
            boolean res = getAllChild(c, child, uid);
            if (!res) return false;
        }
        return true;
    }
}
