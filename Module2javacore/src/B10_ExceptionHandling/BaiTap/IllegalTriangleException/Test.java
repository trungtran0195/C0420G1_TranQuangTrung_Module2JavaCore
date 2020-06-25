package B10_ExceptionHandling.BaiTap.IllegalTriangleException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap canh a :");
        double a = scanner.nextDouble();

        System.out.println("nhap canh b :");
        double b = scanner.nextDouble();

        System.out.println("nhap canh c :");
        double c = scanner.nextDouble();

        try {
            Triangle triangle = new Triangle(a, b, c);
            triangle.showInfo();
        }catch (InputMismatchException e){
            System.err.println("phai nhap so");
        }catch (IllegalTriangleException e){
            System.err.println("Hinh tam giac khong hop le tai vi tri: " +e.getMessage());
        }
    }
}
