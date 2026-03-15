public class Person {

    // RED
    private String name;
    private char gender;
    private int age;

    Person(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // RED
    public String getName() {
        return name;
    }

    // RED
    public char getGender() {
        return gender;
    }

    // RED
    public int getAge() {
        return age;
    }

    // RED
    public void setAge(int age) {
        this.age = age;
    }
}
