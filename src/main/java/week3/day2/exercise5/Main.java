package week3.day2.exercise5;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Hanni", "Salman",25);
        System.out.println(person);

        person.setAge(26);
        System.out.println(person.getAge());
    }

}
