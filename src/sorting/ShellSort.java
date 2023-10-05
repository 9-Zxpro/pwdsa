package sorting;

public class ShellSort {
    static void shellSort(int[] a) {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = a[i];
                int j=i;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] val = {7, 5, 2, 3, 9, 6};
        shellSort(val);
        for (int v : val) {
            System.out.print(v + " ");
        }
    }
}
