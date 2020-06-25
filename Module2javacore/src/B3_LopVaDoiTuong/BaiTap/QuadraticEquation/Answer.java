package B3_LopVaDoiTuong.BaiTap.QuadraticEquation;

import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a:");
        double a = sc.nextDouble();
        System.out.print("Nhap b:");
        double b = sc.nextDouble();
        System.out.print("Nhap c:");
        double c = sc.nextDouble();
        QuadraticEquation quadraticequation = new QuadraticEquation(a, b, c);
        if (quadraticequation.getDiscriminant() >= 0) {
            System.out.println("this equation has 2 roots" + "r1 = " + quadraticequation.getRoot1() + "r2 = " + quadraticequation.getRoot2());
        } else if (quadraticequation.getDiscriminant() == 0) {
            System.out.println("this equation has 1 root = " + quadraticequation.getRoot1());
        } else if (quadraticequation.getDiscriminant() < 0) {
            System.out.println("this equation has no real roots");
        }
    }
}
