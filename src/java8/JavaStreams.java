package java8;

import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student
{
    int roll;
    int marks;
    String name;

    // Constructor to assign values
    Student(int r, String n, int m)
    {
        roll = r;
        name = n;
        marks = m;
    }
    int getRoll()
    {
        return roll;
    }
    String getName()
    {
        return name;
    }
    int getMarks()
    {
        return marks;
    }
}

class Person {

    private int age;
    private String name;
    private String country;

    public Person(int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name;

    }
}

public class JavaStreams {
    public static void main (String[] args) {
        int[] arr = {30, 20, 10};

        int maxi = Arrays.stream(arr)
                .max()
                .getAsInt();
        System.out.println(maxi);

//        Stream.iterate(1, x -> x+1)
//                .filter(x -> x.toString().contains("5"))
//                .limit(10)
//                .forEach(System.out::println);

        Student[] std = { new Student(110, "abc", 70),
                new Student(101, "bcd", 70),
                new Student(120, "xyz", 60) };
        /*
        * Student::getMarks =>
        * new Function<Student, Integer>() {
        *   @Override
        *   public Integer apply(Student student) {
        *     return student.getMarks();
        *   }
        * }
        */
        Map<Integer, List<Student>> m = Arrays.stream(std)
                .collect(Collectors.groupingBy(Student::getMarks));
//        System.out.println(m);

        List<Person> people = Arrays.asList(
                new Person(20, "John", "USA"),
                new Person(35, "Sam", "Italy"),
                new Person(15, "Jamie", "England"),
                new Person(30, "Robert", "Italy"),
                new Person(20, "James", "Ireland"),
                new Person(25, "Peter", "USA"),
                new Person(5, "Jss", "Norway"),
                new Person(40, "Roger", "Netherlands"),
                new Person(50, "Jim", "USA")
        );
        List<Person> pp = people.stream()
                .filter(person -> person.getAge() > 20 || names(person.getName()))
                .collect(Collectors.toList());
        System.out.println(pp);

    }
    public static boolean names(String name){
        return name.toLowerCase().matches(".*[aeiou].*");
    }
}
