package recursion;

import java.util.ArrayList;

public class StringSubset {

    static ArrayList<String> subset(String s) {
     ArrayList<String> ans = new ArrayList<>();
        if (s.isEmpty()) {
            ans.add("");
            return ans;
        }
        char curr = s.charAt(0);
        ArrayList<String> smallans = subset(s.substring(1));
        for (String ss: smallans) {
            ans.add(ss);
            ans.add(curr+ss);
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<String> sb = subset("abc");
        System.out.println(sb);
    }
}
