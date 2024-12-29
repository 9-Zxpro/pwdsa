package java8.patterns;

class SingletonObj {
    private static SingletonObj SINGLETON_INSTANCE = null;
    private SingletonObj () {}
    public static SingletonObj getInstance() {
        if(SINGLETON_INSTANCE == null) {
            SINGLETON_INSTANCE = new SingletonObj();
        }
        return SINGLETON_INSTANCE;
    }
}

public class Singleton {
    public static void main(String[] args) {
        SingletonObj o1 = SingletonObj.getInstance();
        SingletonObj o2 = SingletonObj.getInstance();
        System.out.println(o1);
        System.out.println(o2);
    }
}