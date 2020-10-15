package Homework6;

import Homework6.animals.Animal;
import Homework6.animals.Cat;
import Homework6.animals.Dog;

public class Main {



    public static void main(String[] args) {
        Cat cat = new Cat("Murka");
        Cat cat1 = new Cat("Mashka");
        cat.swim(0);
        cat.run(100);
        Dog dog = new Dog("Sharik");
        dog.swim(10);
        dog.run(600);
        Animal.printCount();
        Dog.printCount();
        Cat.printCount();




    }


}
