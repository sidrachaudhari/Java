class Shape {
    public double area() {
        return 0;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle(5);
        System.out.println("Area: " + shape.area());
    }
}
