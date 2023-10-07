package sorting;

public class QuickSort {
    static void quickSort(int[] a, int left, int right){
        if(left < right) {
            int pvt = partition(a, left, right);
            quickSort(a, left, pvt-1);
            quickSort(a, pvt+1, right);
        }
    }
//    static int partition(int[] a, int left, int right) {
//        int pivot = left;
//        boolean flag = false;
//
//        while(left < right) {
//            int tmp;
//
//            while(a[pivot] < a[right]) --right;
//
//            if(right == pivot) flag = true;
//            else{
//                tmp = a[right];
//                a[right] = a[pivot];
//                a[pivot] = tmp;
//                pivot = right;
//            }
//
//            if(!flag) {
//                while(a[pivot] > a[left]) ++left;
//
//                if(left == pivot) flag = true;
//                else{
//                    tmp = a[left];
//                    a[left] = a[pivot];
//                    a[pivot] = tmp;
//                    pivot = left;
//                }
//            }
//        }
//        return pivot;
//    }

//    second method ✍️👇
    static int partition(int[] a, int left, int right) {
        int pivot = left;
        boolean flag = false;

        while(true) {
            int tmp;

            do {
                if (left >= right) return pivot;

                while(a[pivot] < a[right]) --right;

                if (right == pivot) flag = true;
                else {
                    tmp = a[right];
                    a[right] = a[pivot];
                    a[pivot] = tmp;
                    pivot = right;
                }
            } while(flag);

            while(a[pivot] > a[left]) ++left;

            if (left == pivot) flag = true;
            else {
                tmp = a[left];
                a[left] = a[pivot];
                a[pivot] = tmp;
                pivot = left;
            }
        }
    }


    public static void main(String[] args) {
        int[] val = {27, 10, 9, 7, 6, 45};
        quickSort(val, 0, val.length-1);
        for (int v : val) {
            System.out.print(v + " ");
        }
    }
}
