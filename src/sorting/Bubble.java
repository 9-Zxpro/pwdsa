package sorting;

public class Bubble {

    // ******basic method**********
//    static void bubbleSort(int[] a) {
//        int n = a.length;
//        for (int i=0; i<n; i++) {
//            for (int j=0; j<n-i-1; j++) {
//                if(a[j] > a[j+1]){
//                    int temp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = temp;
//                }
//            }
//        }
//    }

    //    ********* improved method *****
    static void bubbleSort(int[] a) {
        int n = a.length;
        boolean flag = true;
        for (int i = 0; i < n && flag; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

//    placing zero at the end with stability
//    static void bubbleSort(int[] a) {
//        int n = a.length;
//        boolean flag = true;
//        for (int i = 0; i < n && flag; i++) {
//            flag = false;
//            for (int j = 0; j < n - i - 1; j++) {
//                if (a[j]==0 && a[j + 1] != 0) {
//                    int temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                    flag = true;
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        int[] val = {0, 5, 0, 42, 3};
        bubbleSort(val);
        for (int v :
                val) {
            System.out.print(v + " ");
        }
    }
}
