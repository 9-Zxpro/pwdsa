package LinkedLists;

import java.util.Scanner;

public class LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the number of nodes : ");
        int n = sc.nextInt();
        SinglyLinkedList sll = new SinglyLinkedList();
        System.out.print("enter the numbers : ");
        for (int i=0; i<n; i++){
            sll.addNodeAtBeg(sc.nextInt());
        }
        sll.addNodeBefore(90, 8);
        sll.display();
    }
}

/*
Indexing    -> O(n)
Insertion/Deletion at beginning    -> O(1)
Insertion/Deletion at ending/middle    -> O(n)
*/

/*
Skip List
It is a probabilistic data structure alternative to balanced trees. It can be used as an alternative to balanced binary
trees. As compared to a binary tree, skip list allow quick search, insertion and deletion of elements.
This is achieved by using probabilistic balancing rather than strictly enforce balancing. It is a basically a linked
list with additional pointers such that intermediate nodes can be skipped. It uses a random number generator to make
some decisions.

It gives average complexity for insertion/deletion/search as O(log n).
worst case  - O(n).
 */