package Homework7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public String getName() {
        return this.name;
    }
    public int getAppetite(){

        return this.appetite;
    }

    public boolean isFull() {
        return isFull;
    }



    public void eat(Plate plate) {
        System.out.println(this.name + " пытается поесть");
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            isFull = true;
        }
        else isFull = false;
    }

    public void catISFull(){
        if (isFull()){
            System.out.println(this.name + " успешно покушал и теперь сыт");
        }
        if (!isFull()){
            System.out.println(this.name + ": еды слишком мало, чтобы покушать");
        }
    }

}
