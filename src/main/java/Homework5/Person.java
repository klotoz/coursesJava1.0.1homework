package Homework5;

public class Person {
    private String fio;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;

    public Person(String fio, String position, String email, int phone, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public void getFullInfo(){
        System.out.println("fio:" + fio +", position: " + position
                + ", email: " + email + ", salary: " + salary + ", age: "
                + age);
    }

    int getAge(){
        return age;
    }





}


