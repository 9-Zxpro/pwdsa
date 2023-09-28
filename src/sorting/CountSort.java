package sorting;

public class CountSort {

    static int max(int[] a) {
        int m = a[0];
        for (int x : a) {
            if(m < x) m = x;
        }
        return m;
    }
    static void countSort(int[] a) {
        int m = max(a);
        int[] freq = new int[m+1];
        for (int x : a) {
            freq[x]++;
        }
        for (int i=1; i<freq.length; i++) {
            freq[i] = freq[i-1] + freq[i];
        }
        int[] otpt = new int[a.length];
        for(int i=a.length-1; i>=0; i--){
            int ind = freq[a[i]]-1;
            otpt[ind] = a[i];
            freq[a[i]]--;
        }
        System.arraycopy(otpt, 0, a, 0, otpt.length);
    }
    public static void main(String[] args) {
        int[] val = {2, 7, 9, 4, 2, 3, 7};
        countSort(val);
        for (int v : val) {
            System.out.print(v + " ");
        }
    }
}
