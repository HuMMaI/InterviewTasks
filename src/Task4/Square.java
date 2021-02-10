package Task4;

public class Square extends Shape {
    public int side;

    public Square(int side) {
        super("Square");
        this.side = side;

        this.area = side * side;
    }
}
