public class Sphere extends Shape {
    public Sphere(double radius) {
        super(0, 0, radius, 0, 0);
    }

    @Override
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
}
