package sorting;

import heap.Heap;

import java.util.ArrayList;
import java.util.List;

/*
The heap sort algorithm inserts all elements into a heap, then removes them from the root of a heap until the heap
is empty. To do sorting in-place, instead of deleting an element, exchange the first element with the last element and
reduce the heap size.

 */
public class HeapSort {
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(2);
        heap.add(12);
        heap.add(32);
        heap.add(21);
        heap.add(9);
        heap.add(1);
        heap.add(5);

        int n = heap.size();

//        build heap
        for(int i=n/2-1; i>=0; i--) {
            Heap.heapifyMin(heap, n, i);
        }
        System.out.println("Min Heap:");
        System.out.println(heap);

//      heap sort
        Heap.heapSort(heap, n);
        System.out.println("Sorted by heap: ");
        System.out.println(heap);
    }

}
