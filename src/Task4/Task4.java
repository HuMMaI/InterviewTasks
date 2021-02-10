package Task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        int side = 3;
        int radius = 1;
        int base = 5;
        int height = 2;
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Square(side));
        shapes.add(new Rectangle(side, height));
        shapes.add(new Triangle(base, side));
        shapes.add(new Circle(radius));

        shapes.sort(Comparator.comparingInt(shape -> shape.area));

        for (Shape shape: shapes) {
            System.out.println(shape);
        }
    }

}
