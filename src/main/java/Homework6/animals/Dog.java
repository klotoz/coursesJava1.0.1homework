package Homework6.animals;

public class Dog extends Animal {
    private static int countD;


    public Dog(String name) {
        super(name);
        maxValueSwim = 10;
        maxValueRun = 500;
        countD++;
    }

    public static void printCount(){
        System.out.println("Всего собак: " + countD);
    }



}
