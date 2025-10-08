// HelloOOP.java
class Person {
    private String name;
    private String nim;

    public Person(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public void sayHello() {
        System.out.println("Hello World, I am " + name + "-" + nim);
    }
}

public class HelloOOP {
    public static void main(String[] args) {
        Person me = new Person("Hanifah", "240202864");
        me.sayHello();
    }
}
