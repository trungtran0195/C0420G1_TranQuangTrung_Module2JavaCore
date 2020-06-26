package B10_ExceptionHandling.BaiTap.IllegalTriangleException;

import java.util.InputMismatchException;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3)
            throws illegalTriangleException, InputMismatchException {
        if (side1 + side2 <= side3 ||
                side1 + side3 <= side2 ||
                side2 + side3 <= side1)
            throw new illegalTriangleException(side1, side2, side3);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public void showInfo() {
        System.out.println("hinh tam giac co canh :" +side1+","+ side2+","+side3 +"voi chu vi la:"+getPerimeter());
    }
}
