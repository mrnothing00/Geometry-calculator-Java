public class Cube extends Shape {
    public Cube(double length) {
        super(length, 0, 0, 0, 0);
    }

    @Override
    public double calculateSurfaceArea() {
        return 6 * length * length;
    }

    @Override
    public double calculateVolume() {
        return length * length * length;
    }
}
