public class Car extends Vehicle {

    public static void main(String[] args) {
        Car Car = new Car();
        Car.accelerate();
        Car.accelerate();

        System.out.println("Car speed: " + Car.getSpeed());
    }
}

