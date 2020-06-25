package B2_MangVaPhuongThuc.BaiTap;

import java.util.Scanner;

public class addArray {
    public static void main(String[] args) {
        //N là arraysize
        int arraysize;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter array size: ");
        arraysize = sc.nextInt();
        int[] arraySample = new int[arraysize];
        //Nhập vị trí index của mảng để nhập giá trị X mới
        System.out.print("enter input number :");
        int X = sc.nextInt();
        System.out.print("enter number position in array:");
        int index = sc.nextInt();
        for (int i = 0; i <= arraySample.length; i++) {
            if (index <= 1 && index >= arraySample.length - 1) {
                System.out.println("Vị trí bạn nhập vượt quá mảng!");
                break;
            } else {
                arraySample[index] = X;
            }
        }
        for (int j = 0; j <= arraySample.length; j++) {
            System.out.println(arraySample[j]);
        }
    }
}
