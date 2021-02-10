package Task4;

public class Rectangle extends Shape {
    public int width;
    public int height;

    public Rectangle(int width, int height) {
        super("Rectangle");
        this.width = width;
        this.height = height;

        this.area = width * height;
    }

    public int getArea() {
        return area;
    }
}
