public abstract class Shape {
    protected double length;
    protected double width;
    protected double radius;
    protected double base;
    protected double height;

    public Shape(double length, double width, double radius, double base, double height) {
        this.length = length;
        this.width = width;
        this.radius = radius;
        this.base = base;
        this.height = height;
    }

    public abstract double calculateSurfaceArea();

    public abstract double calculateVolume();

    public boolean areInputsMissingForSurfaceArea() {
        return (radius == 0 && (length == 0 || width == 0 || base == 0 || height == 0));
    }

    public boolean areInputsMissingForVolume() {
        return (radius == 0 && length == 0 && width == 0 && height == 0);
    }
}
