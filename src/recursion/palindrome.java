package recursion;

public class palindrome {
    private static boolean palindromeCheck(String n, int l, int r) {
        if (l >= r ) return true;
        return (n.charAt(l) == n.charAt(r) && palindromeCheck(n, l+1, r-1));

    }

    public static void main(String[] args) {
        System.out.println(palindromeCheck("naeemeean", 0, 8) + " ");
    }
}
