package ch10;

public class JavaCarExample {
    private int passengers = 4;

    public JavaCarExample() {
        System.out.println("passengers: " + this.passengers);
    }

    public JavaCarExample(int passengers) {
        this.passengers = passengers;
        System.out.println("passengers: " + this.passengers);
    }

    public int getPassengers() {
        return passengers;
    }
}
