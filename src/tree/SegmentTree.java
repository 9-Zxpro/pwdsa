package tree;

/*
Segment Tree is a versatile data structure used in computer science and data structures that allows efficient querying
and updating of intervals or segments of an array. It is particularly useful for problems involving range queries,
such as finding the sum, minimum, maximum, or any other operation over a specific range of elements in an array.
The tree is built recursively by dividing the array into segments until each segment represents a single element.
This structure enables fast query and update operations with a time complexity of O(log n), making it a powerful
tool in algorithm design and optimization.

Types of Operations:
 ● Finding Range Sum Queries
 ● Searching index with given prefix sum
 ● Finding Range Maximum/Minimum
 ● Counting frequency of Range Maximum/Minimum
 ● Finding Range GCD/LCM
 ● Finding Range AND/OR/XOR
 ● Finding number of zeros in the given range or finding index of Kth zero

Once the Segment Tree is built, its structure cannot be changed. We can update the values of nodes but we cannot change
its structure. Segment tree provides two operations:
Update: To update the element of the array and reflect the corresponding change in the Segment tree.
Query: In this operation we can query on an interval or segment and return the answer to the problem
(say minimum/maximum/summation in the particular segment).

Lazy Propagation: A speedup technique for range updates
We make an array called lazy[] to stand in for the lazy node. The size of lazy[] is the same as the array used to
represent the segment tree. The goal is to set all the lazy[elements] to 0.
There are no pending changes on the segment tree node i if lazy[i] has a value of 0.
A non-zero value for lazy[i] indicates that before doing any queries on node i in the segment tree,
this sum needs to be added to the node.

Time complexity: The time complexity of segment tree operations like build, update, and the query is O(log N),
which is higher than some other data structures like the Fenwick tree.
Space complexity: The space complexity of a segment tree is O(4N) which is relatively high.

▬ Euler tour: is defined as a way of traversing tree such that each vertex is added to the tour when we visit it
(either moving down from parent vertex or returning from child vertex). We start from root and reach back to root
after visiting all vertices. It requires exactly 2*N-1 vertices to store Euler tour.
         1
        /
       2
      / \
     3   4
Output: 1 2 3 2 4 2 1   (using DFS)

 */

public class SegmentTree {
    static class Node {
        int start, end, sum;
        Node left, right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Constructor to build the Segment Tree
    public SegmentTree(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    // Build the Segment Tree recursively
    private Node buildTree(int[] nums, int start, int end) {
        if (start > end) return null;

        Node node = new Node(start, end);
        if (start == end) {
            node.sum = nums[start]; // Leaf node stores the array value
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid + 1, end);
        node.sum = (node.left != null ? node.left.sum : 0) + (node.right != null ? node.right.sum : 0);

        return node;
    }

    // Query for the sum in the range [L, R]
    public int queryRange(int L, int R) {
        return queryRange(root, L, R);
    }

    private int queryRange(Node node, int L, int R) {
        if (node == null || L > node.end || R < node.start) return 0; // Out of range

        if (L <= node.start && R >= node.end) return node.sum; // Fully within range

        // Partially within range
        return queryRange(node.left, L, R) + queryRange(node.right, L, R);
    }

    // Update a specific index to a new value
    public void update(int index, int value) {
        update(root, index, value);
    }

    private void update(Node node, int index, int value) {
        if (node == null || index < node.start || index > node.end) return; // Out of range

        if (node.start == node.end) { // Leaf node
            node.sum = value;
            return;
        }

        update(node.left, index, value);
        update(node.right, index, value);
        node.sum = (node.left != null ? node.left.sum : 0) + (node.right != null ? node.right.sum : 0);
    }

    // Example usage
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(nums);

        // Query sum from index 1 to 3
        System.out.println("Sum of range [1, 3]: " + segTree.queryRange(1, 3)); // Output: 15

        // Update index 1 to value 10
        segTree.update(1, 10);
        System.out.println("Sum of range [1, 3] after update: " + segTree.queryRange(1, 3)); // Output: 22
    }
}
