package Homework6.animals;

public class Cat extends Animal {

    private static int countC;

    public Cat(String name) {
        super(name);
        maxValueRun = 200;
        countC++;

    }

    @Override
    public void swim(int m) {
        System.out.println( name + " не хочет плыть. Коты не плавают!");
    }

    public static void printCount(){
        System.out.println("Всего кошек: " + countC);
    }
}
