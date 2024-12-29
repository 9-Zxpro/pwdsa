package cp;

/*
This algorithm efficiently locates all instances of a specific pattern within a text in linear time. If the length of
the text is “n” and the length of the pattern is “m,” then the total time taken is O(m + n), with a linear auxiliary
space. It is worth noting that the time and auxiliary space of this algorithm is the same as the KMP algorithm, but
this particular algorithm is simpler to comprehend. In this approach, we create a Z array as part of the process.

 */
import java.util.*;

public class ZAlgorithm {
    public static int minimumOperations(int[] nums) {
        int n = nums.length;
        HashSet<Integer> f = new HashSet<>();
        for(int x : nums) {
            f.add(x);
        }
        if(f.size() == n) return 0;

        int ans = 0;
        int i = 0;

        while (i<n) {
            int rem = Math.min(3, n-i);
            i+=rem;
            ans++;

            f.clear();
            for(int j=i; j<n; j++) {
                f.add(nums[j]);
            }
            if(f.size() == n-i) break;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,11,12,12};
        System.out.println(minimumOperations(nums));
    }
}
