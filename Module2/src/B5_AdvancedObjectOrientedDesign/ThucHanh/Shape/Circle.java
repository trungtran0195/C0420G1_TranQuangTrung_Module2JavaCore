package NgonNguLapTrinhJava.B5_InterfaceAndAbstractClass.ThucHanh.Shape;

public class Circle extends Shape implements Resizeable {
    //Có thêm thuộc tính radius (double) với giá trị mặc định là : 1.0
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    //Được cài đè phương thức toString trả về chuỗi ký tự theo mẫu "A Circle with radius=xxx, which is a subclass of yyy". Trong đó yyy là kết quả thực thi từ phương thức toString của lớp Shape
    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {

    }
}