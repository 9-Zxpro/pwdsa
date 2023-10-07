package sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    static void bucketSort(float[] a) {
        int n = a.length;
        ArrayList<Float>[] buckets = new ArrayList[n/2];
        for(int i=0; i<n/2; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (float v : a) {
            int bInd = (int) v * (n / 2);
            buckets[bInd].add(v);
        }
        for(int i=0; i<n/2; i++) {
            Collections.sort(buckets[i]);
        }
        int ind = 0;
        for (int i = 0; i<n/2; i++) {
            int bSize = buckets[i].size();
            for(int j =0; j<bSize; ++j) {
                a[ind++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] val = {.2f, .4f, .12f, 0.9f, 0.5f, 0.32f};
        bucketSort(val);
        for (var x : val) {
            System.out.print(x+" ");
        }
    }
}
