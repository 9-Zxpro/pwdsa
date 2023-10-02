package searching;

public class LinearSearch {
//    static int linearSearch(int[] a, int v) {
//        for (int x=0; x<a.length; x++) {
//            if(a[x] == v) return x;
//        }
//        return -1;
//    }

//   ---------- improved version  --------------
    static int linearSearch(int[] a, int v) {
        int x=0, y=a.length-1;
        while (x<y) {
            if(a[x] == v) return x;
            if(a[y] == v) return y;
            ++x;
            --y;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] val = {7, 5, 2, 3, 9, 6,4,77,33,555,86,44,889,23,45,21,98,233};
//        Scanner sc = new Scanner(System.in);
//        int sVal = sc.nextInt();
        int ind = linearSearch(val, 555);
        if(ind > 0) System.out.print("found at index " + ind);
        else System.out.print("Not found");
    }
}
