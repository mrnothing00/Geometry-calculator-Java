public class Rectangle extends Shape {
    public Rectangle(double length, double width) {
        super(length, width, 0, 0, 0);
    }

    @Override
    public double calculateSurfaceArea() {
        return length * width;
    }

    @Override
    public double calculateVolume() {
        throw new UnsupportedOperationException("Volume calculation is not applicable for a rectangle.");
    }
}
