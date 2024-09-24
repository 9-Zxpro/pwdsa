package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GfgLive {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i<=100; i++) l.add(i);
        List<Integer> filteredL = l.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 5 == 0 || x % 7 == 0;
            }
        }).toList();
        System.out.println(filteredL);
    }
}
