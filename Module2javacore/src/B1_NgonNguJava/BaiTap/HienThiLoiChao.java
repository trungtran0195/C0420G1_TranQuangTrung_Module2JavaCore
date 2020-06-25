package B1_NgonNguJava.BaiTap;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        //nhap ten
        Scanner scname = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name1 = scname.nextLine();
        //in ten
        System.out.println("Hello: " + name1);
    }
}

