package cp;

/*
A difference array is a powerful technique used to efficiently apply range updates and calculate the resulting array
values. It is particularly useful when multiple updates need to be applied to a range of elements in an array,
as it can consolidate multiple updates and allow for quick computations.

Key Concepts of Difference Array -
    Difference Array Definition:

        For an array arr[] of size n, the difference array diff[] is defined as:
                diff[i] = arr[i] - arr[i-1]  (for i>0)
        For i=0:
                diff[0] = arr[0]

        Using diff[], the original array can be reconstructed as:
                arr[i]=arr[0]+sum(diff[0..i])

Purpose:
A difference array allows us to apply incremental updates to a range of elements in constant time O(1).
After applying updates, we can reconstruct the final array in O(n) by taking the prefix sum of diff[].

Example
    arr=[0,0,0,0,0]     diff=[0,0,0,0,0]
    Now, consider the following range updates:
        Add +2 to all elements from index 1 to 3.
        Add +3 to all elements from index 2 to 4.

    For +2 on [1,3]: diff[1]+=2, diff[4]−=2
    For +3 on [2,4]: diff[2]+=3,diff[5]−=3
    diff becomes: diff=[0,2,3,0,−2]

    Construct the Final Array:
        arr[0]=diff[0]=0
        arr[1]=arr[0]+diff[1]=0+2=2
        arr[2]=arr[1]+diff[2]=2+3=5
        arr[3]=arr[2]+diff[3]=5+0=5
        arr[4]=arr[3]+diff[4]=5−2=3

     Final array:
        arr=[0,2,5,5,3]

 */

import static utility.Util.factor;

public class DifferenceArray {
    public static void applyDiff(int[] diff, int n, int l, int r, int v) {
        diff[l] += v;
        if(r+1 < n)
            diff[r+1] -= v;
    }
    public static void convertToOriginal(int[] arr, int[] diff) {
        arr[0] = diff[0];
        for(int i=1; i<arr.length; i++) {
            arr[i] = diff[i]+arr[i-1];
        }
    }

    public static void main(String[] args) {
        int n = 5; // Size of the array
        int[] arr = new int[n]; // The original array
        int[] diff = new int[n]; // The difference array

        // Applying updates: Add +2 from index 1 to 3
        applyDiff(diff, n, 1, 3, 2);

        // Applying another update: Add +3 from index 2 to 4
        applyDiff(diff, n, 2, 4, 3);

        // Convert difference array to the original array
        convertToOriginal(arr, diff);

        // Print the final array
        System.out.println("Updated Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        int[] smallest_multiple = new int[n];
        for(int i=0; i<n; i++) {
            smallest_multiple[i] = -1;
        }
        int i=0;
        for(int item : arr) {
            for (int d : factor(item)) {
                if(smallest_multiple[d]==-1|| arr[smallest_multiple[d]] > item){
                    smallest_multiple[d]=i;
                }
            }
            i++;
        }
    }

}
