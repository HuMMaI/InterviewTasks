package Task4;

public class Triangle extends Shape {
    public int base;
    public int side;

    public Triangle(int base, int side) {
        super("Triangle");
        this.base = base;
        this.side = side;

        this.area = (int) (base * (Math.sqrt((side * side - ((base / 2.0) * (base / 2.0))))));
    }

    public int getArea() {
        return area;
    }
}
