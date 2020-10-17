package Homework7;

public class Main {

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Murzik", 10);
        cats[1] = new Cat("Basik", 20);
        cats[2] = new Cat("Murka", 30);
        cats[3] = new Cat("Muska", 30);
        cats[4] = new Cat("Goga", 40);
        Plate plate = new Plate(100);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.catISFull();
            System.out.println(plate);
        }

        plate.enlargeFood(100);
        System.out.println(plate);


    }

}