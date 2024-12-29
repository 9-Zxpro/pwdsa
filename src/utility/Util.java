package utility;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /*
    Multiple:
    A multiple of a number is the result of multiplying that number by an integer.
    In simpler terms, if a and b are integers, then b is a multiple of a if b=a×k, where k is an integer.
        Example:
            Multiples of 3: 3,6,9,12,15,… (obtained by 3×1,3×2,3×3,…).
            Multiples of 5: 5,10,15,20,25,….
    Factor:
    A factor (or divisor) of a number is a number that divides it exactly without leaving a remainder.
    If a and b are integers, then a is a factor of b % a=0.
        Example:
            Factors of 12: 1,2,3,4,6,12 (since 12mod1=0,12mod2=0,…).
            Factors of 15: 1,3,5,15.
     */

    //    all divisors of a number
    public static List<Integer> factor(int n) {
        List<Integer> res = new ArrayList<>();
        for(int d = 1; d*d<=n; d++) {
            if(n%d!=0) continue;
            res.add(d);
            if(d*d != n) {
                res.add(n/d);
            }
        }
        return res;
    }

}
