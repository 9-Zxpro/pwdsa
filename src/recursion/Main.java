package recursion;

//import java.util.ArrayList;
//import java.util.Collection

import org.jetbrains.annotations.NotNull;

public class Main {

//    static int c = 0;
//    private static int max(int[] n, int k, int m) {
//
//        if(k == n.length-1) {
//            return m;
//        }
//        return max(n, k+1, Math.max(n[k], m));
//    }

    private static boolean stringMnp(@NotNull String n, int l, int r) {
        if (l >= r ) return true;
        return (n.charAt(l) == n.charAt(r) && stringMnp(n, l+1, r-1));

    }

    public static void main(String[] args) {
//        int[] arr = {3,5,16,8,9,2,2};

        System.out.println(stringMnp("naeemeean", 0, 8) + " ");

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();



    }
}