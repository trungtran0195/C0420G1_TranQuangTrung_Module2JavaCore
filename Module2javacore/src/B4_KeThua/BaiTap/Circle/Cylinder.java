package B4_KeThua.BaiTap.Circle;

public class Cylinder extends Circle {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public double getRadius() {
        return getRadius();
    }

    public double getVolume() {
        return height * getRadius() * super.getRadius() * Math.PI;
    }

    @Override
    public void setRadius(double radius) {
        setRadius(radius);
    }

    @Override
    public String toString() {
        return "A Cylinder with height="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}
