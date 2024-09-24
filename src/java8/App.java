package java8;

import java.awt.*;
import java.io.Console;
import java.util.Arrays;
import java.util.Comparator;

class A{
    static {
        System.out.println("Class Loading.....");
    }
    A(){
        System.out.println("Object Creating.....");
    }
}

interface Age {
    int x = 21;
    void getAge();
//    protected interface AA{
//        void dis();
//    }
}

public class App {
public static int v = 20;
public int s = 2;
//static class Nes{
//    private void dis() {
//        System.out.println(s+"hell");
//    }
//}

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//        for(int i=0; i<t; i++) {
//            int n = sc.nextInt();
//            int x = sc.nextInt();
//            int[] station = new int[n];
//            for(int j = 0; j<n; j++) {
//                station[j] = sc.nextInt();
//            }
//            Solutions obj = new Solutions();
//            System.out.println(obj.maxFuel(station, x));
//        }
//        sc.close();

        Age oj1 = new Age() {
            @Override
            public void getAge() {
                System.out.println("Age is " + Age.x);
                System.out.println(8&9);
            }
        };



        oj1.getAge();

//        Console console = System.console();
//        String uname = console.readLine("User Name : ");
//        char[] pwd = console.readPassword("Password :");
//        String upwd = new String(pwd);
//        if(uname.equals("durga") && upwd.equals("durga")) {
//            System.out.println("User Login Success");
//        }else {
//            System.out.println("User Login Failure");
//        }

        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }
}

class Solutions{
    public int maxFuel(int[] a, int x){
        int fuel = 0;
        fuel = Math.max(fuel, a[0]);
        for(int i=1; i<a.length; i++){
            fuel = Math.max(fuel, (a[i]-a[i-1]));
        }
        fuel = Math.max(fuel, (x-a[a.length-1])*2);

        return fuel;
    }
}
