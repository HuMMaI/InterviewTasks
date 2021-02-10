package Task4;

public class Circle extends Shape {
    public int radius;

    public Circle(int radius) {
        super("Circle");
        this.radius = radius;

        this.area = (int) ((radius * radius) * Math.PI);
    }

    public int getArea() {
        return area;
    }
}
