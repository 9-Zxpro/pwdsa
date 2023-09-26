package sorting;

public class MergeSort {
//    lInd = left index
//    rInd = right index

    static void merge(int[] a, int lInd, int mid, int rInd) {
        int i = lInd, j = mid + 1, c = lInd;
        int[] tmp = new int[a.length];
        while (i <= mid && j <= rInd) {
            if (a[i] < a[j]) tmp[c++] = a[i++];
            else tmp[c++] = a[j++];
        }
        while (i <= mid) {
            tmp[c++] = a[i++];
        }
        while (j <= rInd) {
            tmp[c++] = a[j++];
        }
        if (c - lInd >= 0) System.arraycopy(tmp, lInd, a, lInd, c - lInd);
    }

    static void mergeSort(int[] a, int lInd, int rInd) {

        if (lInd < rInd) {
            int mid = lInd + (rInd - lInd) / 2;
            mergeSort(a, lInd, mid);
            mergeSort(a, mid + 1, rInd);
            merge(a, lInd, mid, rInd);
        }
    }

    public static void main(String[] args) {
        int[] val = {7, 5, 2, 3, 9, 6};
        mergeSort(val, 0, val.length-1);
        for (int v : val) {
            System.out.print(v + " ");
        }
    }
}
