public class Cone extends Shape {
    public Cone(double radius, double height) {
        super(0, 0, radius, 0, height);
    }

    @Override
    public double calculateSurfaceArea() {
        return Math.PI * radius * (radius + height);
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
}
