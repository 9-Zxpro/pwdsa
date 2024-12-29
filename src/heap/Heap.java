package heap;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

/*
A priority queue is a type of queue that arranges elements based on their priority values. Elements with higher
priority values are typically retrieved or removed before elements with lower priority values. Each element has a
priority value associated with it. When we add an item, it is inserted in a position based on its priority value.

A priority queue is called ascending-priority queue, if the item with the smallest key has the highest priority (delete
the smallest element always). Similarly, a descending-priority queue, if the item with the largest key has the highest
priority (delete the maximum element always).

Applications:
 ● Dijkstra’s Shortest Path Algorithm using priority queue: When the graph is stored in the form of adjacency list or
 matrix, priority queue can be used to extract minimum efficiently when implementing Dijkstra’s algorithm.
 ● Prim’s algorithm: It is used to implement Prim’s Algorithm to store keys of nodes and extract minimum key node at every step.
 ● Data compression : It is used in Huffman codes which is used to compresses data.
 ● Artificial Intelligence : A* Search Algorithm : The A* search algorithm finds the shortest path between two
 vertices of a weighted graph, trying out the most promising routes first.
 ● The priority queue (also known as the fringe) is used to keep track of unexplored routes, the one for which a
 lower bound on the total path length is smallest is given highest priority.
 ● Heap Sort : Heap sort is typically implemented using Heap which is an implementation of Priority Queue.
 ● Scheduling Algorithms: It is also used in Operating System for load balancing, interrupt handling.
 ● Optimization problems: used in optimization problems such as Huffman coding, Kruskal’s Algorithm.
 ● Robotics: Priority Queue is used in robotics to plan and execute tasks in a priority-based manner.
 ● Event-driven simulations: Priority queues are used in event-driven simulations, such as network simulations,
 to determine which events should be processed next.
 ● Medical systems: Priority queues are used in medical systems, such as triage systems in emergency departments,
 to prioritize patients based on the urgency of their condition.
 ● Order statistics: The Heap data structure can be used to efficiently find the kth smallest (or largest) element
 in an array. See method 4 and 6 of this post for details.

Priority queue can be implemented using the following data structures:
 Ordered Arrays     insertion-O(n) deletion-O(1) find_min-O(1)
 Ordered Linked list    insertion-O(n) deletion-O(1) find_min-O(1)
 Binary search tree     insertion-O(log n) deletion-O(log n) find_min-O(log n)
 Heap data structure    insertion-O(log n) deletion-O(log n) find_min-O(1)

▬ Binary Heap: A binary heap is a specific type of heap data structure that is based on a complete binary tree and
satisfies the heap property.
Heap Property:
    • Max-Heap: The value of each parent node is greater than or equal to the values of its child nodes
      (Parent ≥ Children). The largest element is at the root.
    • Min-Heap: The value of each parent node is less than or equal to the values of its child nodes
      (Parent ≤ Children). The smallest element is at the root.

A heap can be efficiently represented as an array:
    For a node at index i:
       • Left child: 2 * i + 1
       • Right child: 2 * i + 2
       • Parent: (i - 1) / 2 (integer division)

Percolate down - moving from top to bottom (heapifying process)
Percolate up - moving from bottom to top (heapifying process)

Deleting an element uses PercolateDown, and inserting an element uses PercolateUp.

 */

public class Heap {

//    ------ start min heap--------
    private static void insertInMinHeap(List<Integer> heap, int val) {
        heap.add(val);
        int index = heap.size()-1;
        push_up_minHeap(heap, index);
    }

    // Heapify-up to maintain the min-heap property when element inserted
    private static void push_up_minHeap(List<Integer> heap, int i) {
        int parent_ind = (i-1)/2;
        if(i==0 || heap.get(parent_ind) < heap.get(i)) return;
        swap(heap, parent_ind, i);
        push_up_minHeap(heap, parent_ind);
    }

    private static void deletionInMinHeap(List<Integer> heap) {
        int n = heap.size()-1;
        swap(heap, 0, n);
        heap.remove(n);
        push_down_MinHeap(heap, 0, n-1);
    }

    // Heapify-down to maintain the min-heap property when element deleted
    private static void push_down_MinHeap(List<Integer> heap, int i, int n) {
        if(n==i || i > n) return;
        int left = (2*i)+1;
        int right = (2*i)+2;
        int smallest = i;
        if(left<=n && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if(right<=n && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if(smallest == i) return;
        swap(heap, smallest, i);
        push_down_MinHeap(heap, smallest, n);
    }
//    ------ End min heap--------

//    ------ Start max heap--------

    //    increase the size of heap
    //    add the element at the end of the heap
    //    PercolateUP
    private static void insertInMaxHeap(List<Integer> heap, int val) {
        heap.add(val);
        int index = heap.size()-1;
        push_up_maxHeap(heap, index);
    }

    // Heapify-up to maintain the max-heap property when element inserted
    private static void push_up_maxHeap(List<Integer> heap, int i) {
        int parent_ind = (i-1)/2;
        if(i==0 || heap.get(parent_ind) > heap.get(i)) return;
        swap(heap, parent_ind, i);
        push_up_maxHeap(heap, parent_ind);
    }

    //    swap the root-node[0] with last-node[n-1] in heap array
    //    remove the last-node[n-1]
    //    PercolateDown
    private static void deletionInMaxHeap(List<Integer> heap) {
        int n = heap.size()-1;
        swap(heap, 0, n);
        heap.remove(n);
        push_down_MaxHeap(heap, 0, n);
    }

    // Heapify-down to maintain the max-heap property when element deleted
    private static void push_down_MaxHeap(List<Integer> heap, int i, int n) {
        if(i==n || i > n) return;
        int left = (2*i)+1;
        int right = (2*i)+2;
        int greatest = i;
        if(left<n && heap.get(left) > heap.get(greatest)) {
            greatest = left;
        }
        if(right<n && heap.get(right) > heap.get(greatest)) {
            greatest = right;
        }
        if(greatest == i) return;
        swap(heap, greatest, i);
        push_down_MaxHeap(heap, greatest, n);
    }
//    ------ End max heap --------

/*
Heapify is a process used in a heap data structure to maintain the heap property.
When is heapify Used?
- After inserting a new element: When an element is added to the heap, it might violate the heap property.
- After deleting the root: When the root of the heap is removed, the heap property might be violated.
- During heap construction: To build a heap from an unsorted array, heapify is applied to nodes in reverse level order.

 */

//    ------------- same as push_down_MaxHeap for sorting ---------------
    public static void heapifyMax(List<Integer> heap, int n, int i) {
        int largest = i;
        int left = (i*2)+1;
        int right = (i*2)+2;

        if(left < n && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if(right < n && heap.get(right) > heap.get(largest)) {
            largest = right;
        }
        if(largest != i) {
            swap(heap, largest, i);
            heapifyMax(heap, n, largest);
        }
    }
    public static void heapifyMin(List<Integer> heap, int n, int i) {
//        2 12 32 21 9 1 5
        int smallest = i; // Assume root is the smallest
        int left = (i * 2) + 1; // Left child index
        int right = (i * 2) + 2; // Right child index

        // Check if the left child is smaller than the root
        if (left < n && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        // Check if the right child is smaller than the smallest so far
        if (right < n && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        // If the smallest is not the root
        if (smallest != i) {
            // Swap the root with the smallest
            swap(heap, smallest, i);

            // Recursively heapify the affected subtree
            heapifyMin(heap, n, smallest);
        }
    }

    //    Swap the root (maximum element) with the last element of the current heap.
    //    Reduce the size of the heap by one (i decrements in the loop).
    //    Call heapify on the reduced heap to maintain the heap property.
    public static void heapSort(List<Integer> heap, int n) {
        for(int i = n-1; i>=0; i--){
            swap(heap, i, 0);
            heapifyMin(heap, i, 0);
        }
    }

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();

        // build min-heap
        insertInMinHeap(heap, 1);
        insertInMinHeap(heap, 12);
        insertInMinHeap(heap, 9);
        insertInMinHeap(heap, 5);
        insertInMinHeap(heap, 6);
        insertInMinHeap(heap, 10);

        int n = heap.size();

        System.out.println("Min Heap: ");
        System.out.println(heap);

//        -------build max heap-------
//        for(int i=n/2-1; i>=0; i--) {
//            heapifyMax(heap, n, i);
//        }
//        for(int i=n/2-1; i>=0; i--) {
//            push_down_MaxHeap(heap, i, n);
//        }

        System.out.println("Sorted Heap: ");
        heapSort(heap, n);
        System.out.println(heap);

    }


}
