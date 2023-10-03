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
