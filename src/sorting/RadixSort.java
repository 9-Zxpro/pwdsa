package sorting;

public class RadixSort {
    static int max(int[] a) {
        int m = a[0];
        for (int x : a) {
            if(m < x) m = x;
        }
        return m;
    }
    static void countSort(int[] a, int p) {
        int[] freq = new int[10];
        for (int x : a) {
            int digit = (x/p)%10;
            freq[digit]++;
        }
        for (int i=1; i<10; i++) {
            freq[i] = freq[i-1] + freq[i];
        }
        int[] otpt = new int[a.length];
        for(int i=a.length-1; i>=0; i--){
            int ind = freq[(a[i]/p)%10]-1;
            otpt[ind] = a[i];
            freq[(a[i]/p)%10]--;
        }
        System.arraycopy(otpt, 0, a, 0, otpt.length);
    }
    static void radixSort(int[] a) {
        int m = max(a);
        for (int place=1; m/place > 0; place *= 10) {
            countSort(a, place);
        }
    }
    public static void main(String[] args) {
        int[] val = {2978, 422, 379, 42, 110};
        radixSort(val);
        for (int v : val) {
            System.out.print(v + " ");
        }
    }
}
