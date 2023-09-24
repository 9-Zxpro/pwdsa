package sorting;

public class Insertion {
    static void insertionSort(int[] a) {
        for(int i=1; i<a.length; i++) {
            int j=i;
            while(j>0 && a[j] < a[j-1]) {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] val = {0, 5, 0, 42, 3};
        insertionSort(val);
        for (int v :
                val) {
            System.out.print(v + " ");
        }
    }
}
