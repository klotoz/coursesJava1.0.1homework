package Homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return this.food;
    }

    public void decreaseFood(int appetite) {


        if (food >= appetite) {
            this.food -= appetite;
        }

    }

    public void enlargeFood(int f){
        this.food += f;

    }

    public String toString() {
        return "В тарелке сейчас " + this.food + " еды";
    }
}
