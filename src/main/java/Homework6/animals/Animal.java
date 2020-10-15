package Homework6.animals;

public class Animal {
    protected String name;
    protected int maxValueRun =0;
    protected int maxValueSwim =0;
    static int count =0;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int n){
        if (n>maxValueRun){
            System.out.println(name + " не может пробежать " + n + " m");
        } else System.out.println(name + " пробежал(а) " + n + " m");

    }

    public void swim(int m){
        if (m>maxValueSwim){
            System.out.println(name + " не может проплыть " + m + " m");
        } else System.out.println(name + " проплыл(а) " + m + " m");

    }

    public static void printCount(){
        System.out.println("Всего животных: " + count);
    }

}
