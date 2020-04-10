package B3_LopVaDoiTuong.ThucHanh.Rectangle;

import java.util.Scanner;

public class Ex14_1 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai :");
        double width = sc.nextDouble();
        System.out.print("Nhap chieu rong :");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width , height);
        System.out.println(rectangle.display());
        System.out.println("co chu vi la :" +rectangle.getPerimeter());
        System.out.println("co dien tich la :" +rectangle.getArea());
    }
}
