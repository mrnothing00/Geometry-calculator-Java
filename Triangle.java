public class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(0, 0, 0, base, height);
    }

    @Override
    public double calculateSurfaceArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculateVolume() {
        throw new UnsupportedOperationException("Volume calculation is not applicable for a triangle.");
    }
}
