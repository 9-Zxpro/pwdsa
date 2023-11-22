package hashes;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {

        Map<String, Integer> mp = new java.util.HashMap<>();
        mp.put("aman", 2);
        mp.put("anu", 42);
        mp.put("ram", 21);
        mp.put("love", 22);
        mp.put("pro", 12);
        System.out.println(mp.get("love"));
        mp.put("anu", 23);
        System.out.println(mp.remove("pro")); // returns null if key not exist
        System.out.println(mp.containsKey("aman"));
        System.out.println(mp.containsValue(2));
        mp.putIfAbsent("pro", 30); // will enter if not exist
        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.entrySet()); // prints all entries
        for (int x : mp.values()) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (String x : mp.keySet()) {
            System.out.print(x + " ");
        }
        System.out.println();
        for(Map.Entry<String, Integer> e: mp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        System.out.println();
        for(var e: mp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }

        // can insert only one null key but many null values
        // it doesn't maintain order.

        /*
          Applications

          > problem related to frequency
          > mapping problem
          > storage optimization
          > dictionary
          > phonebook

         */


    }
}
