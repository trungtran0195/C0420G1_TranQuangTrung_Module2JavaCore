package B10_ExceptionHandling.BaiTap.IllegalTriangleException;

import java.util.Scanner;

public class Triangle {
    public static void Triangle(int a ,int b , int c) throws IllegalTriangleException{
        if (a+b > c && a+c>b && b+c>a && a > 0 && b> 0 && c > 0){
            int perimeter = a + b + c;
            System.out.println("chu vi tam giac la :" + perimeter + "voi canh la:" + a + "," + b + ","+c);
        }else {
            throw new IllegalTriangleException();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap canh a :");
        int a = scanner.nextInt();

        System.out.println("nhap canh b :");
        int b = scanner.nextInt();

        System.out.println("nhap canh c :");
        int c = scanner.nextInt();

        try {
            Triangle(a,b,c);
        }catch (Exception e){
            System.err.println("Hinh tam giac khong hop le");
        }
    }

}
