package B6_DataStructuresAndAlgorithmBasic.BaiTap.StackDecimalToBinary;

import java.util.Stack;

import static B6_DataStructuresAndAlgorithmBasic.BaiTap.ProductManage.ScannerUtils.scanner;

public class StackDecimalToBinary {
    public static void main(String args[]){
        int decimal = 0;
        System.out.println("input decimal number : ");
        decimal = scanner.nextInt();
        Stack<Integer> binaryStack  = new Stack<>();
        while (decimal/2 > 0){
            decimal -= decimal/2;
            binaryStack.add(decimal%2);
        }
        System.out.println(binaryStack.toString());
    }
}
