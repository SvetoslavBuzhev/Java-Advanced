package DefiningClassesExercise._01OpinionPool;

public class Person {
    private
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String print() {
        return String.format("%s - %d",name,age);
    }
}
