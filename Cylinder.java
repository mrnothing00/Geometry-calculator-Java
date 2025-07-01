public class Cylinder extends Shape {
    public Cylinder(double radius, double height) {
        super(0, 0, radius, 0, height);
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
}
