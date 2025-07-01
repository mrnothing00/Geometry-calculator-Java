public class Circle extends Shape {
    public Circle(double radius) {
        super(0, 0, radius, 0, 0);
    }

    @Override
    public double calculateSurfaceArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        throw new UnsupportedOperationException("Volume calculation is not applicable for a circle.");
    }
}
