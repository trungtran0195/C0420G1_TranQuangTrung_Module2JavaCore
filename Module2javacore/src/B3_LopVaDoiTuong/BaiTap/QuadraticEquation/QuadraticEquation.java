package B3_LopVaDoiTuong.BaiTap.QuadraticEquation;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        double delta = (b * b) - (4 * a * c);
        return delta;
    }

    public double getRoot1() {
        double r1;
        return r1 = ((-b) + Math.pow(getDiscriminant(), 0.5)) / (2 * a);
    }

    ;

    public double getRoot2() {
        double r2;
        return r2 = ((-b) - Math.pow(getDiscriminant(), 0.5)) / (2 * a);
    }
}
