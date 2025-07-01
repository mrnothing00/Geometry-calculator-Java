public class Cuboid extends Shape {
    public Cuboid(double length, double width, double height) {
        super(length, width, 0, 0, height);
    }

    @Override
    public double calculateSurfaceArea() {
        return 2 * (length * width + width * height + height * length);
    }

    @Override
    public double calculateVolume() {
        return length * width * height;
    }
}
