package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;


public class Heap {


    private static void insertInMinHeap(List<Integer> heap, int val) {
        heap.add(val);
        int index = heap.size()-1;
        push_up_minHeap(heap, index);
    }

    private static void push_up_minHeap(List<Integer> heap, int i) {
        int parent_ind = (i-1)/2;
        if(i==0 || heap.get(parent_ind) < heap.get(i)) return;
//        swap(heap, parent_ind, i);
        Collections.swap(heap, parent_ind, i);
        push_up_minHeap(heap, parent_ind);
    }

//    private static void swap(List<Integer> heap, int parentInd, int i) {
//        int tmp = heap.get(parentInd);
//        heap.set(parentInd, heap.get(i));
//        heap.set(i, tmp);
//    }

    private static void insertInMaxHeap(List<Integer> heap, int val) {
        heap.add(val);
        int index = heap.size()-1;
        push_up_maxHeap(heap, index);
    }

    private static void push_up_maxHeap(List<Integer> heap, int i) {
        int parent_ind = (i-1)/2;
        if(i==0 || heap.get(parent_ind) > heap.get(i)) return;
//        swap(heap, parent_ind, i);
        swap(heap, parent_ind, i);
        push_up_maxHeap(heap, parent_ind);
    }


    private static void deletionInMaxHeap(List<Integer> heap) {
        swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);
        push_down_MaxHeap(heap, 0);
    }

    private static void push_down_MaxHeap(List<Integer> heap, int i) {
        int n = heap.size()-1;
        if(i==n || i > n) return;
        int left = (2*i)+1;
        int right = (2*i)+2;
        int greatest = i;
        if(left<=n && heap.get(left) > heap.get(greatest)) {
            greatest = left;
        }
        if(right<=n && heap.get(right) > heap.get(greatest)) {
            greatest = right;
        }
        if(greatest == i) return;
        swap(heap, greatest, i);
        push_down_MaxHeap(heap, greatest);
    }

    private static void deletionInMinHeap(List<Integer> heap) {
        swap(heap, 0, heap.size()-1);
        heap.remove(heap.size()-1);
        push_down_MinHeap(heap, 0);
    }

    private static void push_down_MinHeap(List<Integer> heap, int i) {
        int n = heap.size()-1;
        if(n==i || i > n) return;
        int left = (2*i)+1;
        int right = (2*i)+2;
        int smallest = i;
        if(left<=n && heap.get(left) > heap.get(smallest)) {
            smallest = left;
        }
        if(right<=n && heap.get(right) > heap.get(smallest)) {
            smallest = right;
        }
        if(smallest == i) return;
        swap(heap, smallest, i);
        push_down_MinHeap(heap, smallest);
    }

    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
//        heap.add(10);
//        heap.add(20);
//        heap.add(30);
//        heap.add(40);
//        heap.add(50);
//        heap.add(60);
//        heap.add(70);


        heap.add(80);
        heap.add(60);
        heap.add(50);
        heap.add(40);
        heap.add(30);
        heap.add(20);
        heap.add(70);
        System.out.println(heap);
//        insertInMaxHeap(heap, 70);
        deletionInMaxHeap(heap);
        System.out.println(heap);

    }


}
