//import java.util.ArrayList;
//import java.util.Collections;

public class Main {

//    static int c = 0;
//    private static int max(int[] n, int k, int m) {
//
//        if(k == n.length-1) {
//            return m;
//        }
//        return max(n, k+1, Math.max(n[k], m));
//    }

    static String s = "";
    private static String stringMnp(String n, int k) {

        if(k==n.length()) return s;
        if(n.charAt(k) != 'a') s += n.charAt(k);
        return stringMnp(n, k+1);
    }

    public static void main(String[] args) {
//        int[] arr = {3,5,16,8,9,2,2};

        System.out.println(stringMnp("amanpatel", 0) + " ");

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();



    }
}