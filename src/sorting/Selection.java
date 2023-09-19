package sorting;

public class Selection {

//    static void selectionSort(int[] a) {
//        for (int i=0; i< a.length; i++) {
//            int min_ind = i;
//            for (int j=i+1; j<a.length; j++) {
//                if(a[j] < a[min_ind])
//                    min_ind = j;
//            }
//            int tmp = a[min_ind];
//            a[min_ind] = a[i];
//            a[i] = tmp;
//        }
//    }

//    organize the given fruits in lexicographically
    static void selectionSort(String[] a) {
        for (int i=0; i< a.length; i++) {
            int min_ind = i;
            for (int j=i+1; j<a.length; j++) {
                if(a[j].compareTo(a[min_ind]) < 0)
                    min_ind = j;
            }
            String tmp = a[min_ind];
            a[min_ind] = a[i];
            a[i] = tmp;
        }
    }
    public static void main(String[] args) {
        String[] val = {"kiwi", "banana", "papaya", "apple", "orange"};
        selectionSort(val);
        for (String v : val) {
            System.out.print(v + " ");
        }
    }
}
