package leetcode;

public class DecodeStringAtIndex_880 {
//    public static String decodeAtIndex(String s, int k) {
//        String rep = "", kth = "";
//        boolean flag = false;
//        int r = 0;
//        int m = -1;
//        for (int i = 0; i < s.length(); i++) {
//            flag = false;
//            if (Character.isDigit(s.charAt(i))) {
//                rep = s.substring(m+1, i);
//                rep = kth + rep;
//                r = s.charAt(i) - '0';
//                flag = true;
//            }
//            if (flag) {
//                m = i;
//                kth = rep.repeat(r);
//            }
//        }
//        kth = String.valueOf(kth.charAt(k-1));
//
//        return kth;
//    }

    public static String decodeAtIndex(String s, int k) {
        long size = 0L;
        int n = s.length();

        // Calculate the size of the decoded string
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                size *= s.charAt(i) - '0';    // (s.charAt(i) - 48)
            } else {
                ++size;
            }
        }

        // Start decoding from the end of the string
        for (int i = n - 1; i >= 0; --i) {
            k = (int)(k % size);

            if (k == 0 && Character.isLetter(s.charAt(i))) {
                return String.valueOf(s.charAt(i));
            }

            if (Character.isDigit(s.charAt(i))) {
                size /= s.charAt(i) - '0';
            } else {
                --size;
            }
        }

        return "";
    }


    public static void main(String[] args) {
        String val = "ha22";
        System.out.print(decodeAtIndex(val, 5));

    }
}
