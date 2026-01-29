class Person {
    String name;
    int age;

    void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "Alice";
        p1.age = 20;

        Person p2 = new Person();
        p2.name = "Bob";
        p2.age = 22;

        p1.introduce();
        p2.introduce();
    }
}
