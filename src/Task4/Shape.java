package Task4;

public class Shape {
    public String shapeName;
    public int area;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    @Override
    public String toString() {
        return shapeName + ", " + area;
    }
}
