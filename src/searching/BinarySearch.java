package searching;

import java.util.Scanner;

public class BinarySearch {
//    static int binarySearch(int[] a, int v) {
//        int beg = 0, mid, end = a.length-1;
//        while (beg<=end) {
//            mid = (beg+end)/2;
//            if(a[mid] == v) return mid;
//            else if (a[mid] > v) end = mid-1;
//            else beg = mid+1;
//        }
//        return -1;
//    }

    //    recursive approach
    static int binarySearch(int[] a, int v) {
        int beg = 0, mid, end = a.length - 1;
        if (beg > end) return -1;
        mid = beg + (end - beg) / 2;
        if (a[mid] == v) return mid;
        else if (a[mid] > v) binarySearch(a, mid - 1);
        else binarySearch(a, mid + 1);
        return -1;
    }

    public static void main(String[] args) {
        int[] val = {7, 5, 2, 3, 9, 6};
//        Scanner sc = new Scanner(System.in);
//        int sVal = sc.nextInt();
        int ind = binarySearch(val, 2);
        if (ind > 0) System.out.print("found at index " + ind);
        else System.out.print("Not found");
    }
}
