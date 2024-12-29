package java8;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
interface InnerLambd {
    int sum(int a, int b);
    default void show() {
        System.out.println("hello functional interface!");
    }
}

//abstract class A {
//    public abstract void bill();
//}
//enum Status {
//    Ram(price:90), Shyam, Karan;  //check this property again
//
//    private int price;
//    private Status(int v) {
//        price =v;
//    }
//
//    Status() {
//
//    }
//}

class Pair implements Comparable<Pair>{
    int key;
    int val;
    Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }
    public int compareTo(Pair p) {
        if(this.val != p.val) {
            return p.val - this.val;  //descending order
//            return this.val - p.val;  //Ascending order
        } else {
            return p.key - this.key;  //Descending order
        }
    }
}

public class Lambd {

    public static void main(String[] args) {
        int n = 13;
        Integer autoboxing = Integer.valueOf(n);   /* boxing */

        Integer autoboxing1 = n;    /* autoboxing */

        int unboxing = autoboxing.intValue();   /* unboxing */

        int autoUnboxing = autoboxing;  /* auto-unboxing */

        InnerLambd lm = Integer::sum;   /* method reference; */
        lm.show();

        InnerLambd fun = (a, b) -> a + b;
        fun.show();

        int[][] dist = {{1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 1, 1, 0}};

//        ArrayList<ArrayList<Integer>> ans = Arrays.stream(dist)
//                .map(row -> Arrays.stream(row).boxed().collect(Collectors.toCollection(ArrayList::new)))
//                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<ArrayList<Integer>> ans = Arrays.stream(dist)
                .map(new Function<int[], ArrayList<Integer>>() {
                    @Override
                    public ArrayList<Integer> apply(int[] row) {
                        return Arrays.stream(row).boxed().collect(Collectors.toCollection(ArrayList::new));
                    }
                })
                .collect(Collectors.toCollection(() -> {
                    return new ArrayList<ArrayList<Integer>>();
                }));

//        System.out.println(lm.sum(6,9));

        int[] a = {554,867,454,453,266,965,323};

        List<Integer> arr = new ArrayList<>();
        arr.add(534);
        arr.add(239);
        arr.add(631);
        arr.add(503);
        arr.add(345);
        arr.add(877);

        arr.stream().map(i -> i + " ").forEach(System.out::print);

        /*
        * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer
        * as the first argument is less than, equal to, or greater than the second.
        */
        Comparator<Integer> cm = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 10 > o2 % 10) return 1;
                else return -1;
            }
        };

        Comparator<Pair> cmp = (o1, o2) -> {
            if(o2.val != o1.val) {
                return o2.val - o1.val;
            } else {
                return o2.key - o1.key;
            }
        };
//        Comparator<Integer> customComparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer key1, Integer key2) {
//                // First, get the values associated with the keys
//                int value1 = treeMap.get(key1);
//                int value2 = treeMap.get(key2);
//
//                // Compare by values first
//                if (value1 != value2) {
//                    return Integer.compare(value1, value2); // Ascending order by values
//                }
//
//                // If values are equal, compare by keys
//                return Integer.compare(key1, key2); // Ascending order by keys
//            }
//        };

        // Create the TreeMap with the custom comparator
//        Map<Integer, Integer> treeMap = new TreeMap<>((k1, k2) -> {
//            int v1 = treeMap.get(k1);
//            int v2 = treeMap.get(k2);
//        });
//        Map<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer key1, Integer key2) {
//                int value1 = treeMap.get(key1); // Get value for key1
//                int value2 = treeMap.get(key2); // Get value for key2
//
//                // Compare by values first
//                if (value1 != value2) {
//                    return Integer.compare(value1, value2); // Ascending order by value
//                } else {
//                    return Integer.compare(key1, key2); // Ascending order by key if values are equal
//                }
//            }
//        });

        System.out.println(Math.pow(12, 4));
        System.out.println(12^4);

        arr.sort(cm);

//        System.out.println(arr);
//        System.out.println(Status.Ram);


        //reverse the bit of number
        int tmp = n;
        int rev = 0;
        while(tmp!=0) {
            rev<<=1;
            rev ^= tmp & 1;
            tmp>>=1;
        }
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(rev));

        String[] ar = {"GfG", "IDE", "Courses"};
        String[] br = {"gfg", "id", "courses"};
        if(Arrays.equals(
                ar, br, String::compareToIgnoreCase))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
