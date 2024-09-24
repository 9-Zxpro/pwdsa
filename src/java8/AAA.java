package java8;
class BBB {
    public void dis(int i) {
        System.out.println(i);
    }
}
class CCC extends BBB{
    @Override
    public void dis(int i) {
        System.out.println(i*2);
    }
}
public class AAA {
    public static void main(String[] args) {

        BBB b = new BBB();
        CCC c = new CCC();
        BBB bc = new CCC();
        b.dis(1);
        c.dis(1);
        bc.dis(1);
//        CCC cb = new BBB();
//        cb.dis(2);
    }
}
