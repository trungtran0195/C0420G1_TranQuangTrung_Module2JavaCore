package B6_DataStructuresAndAlgorithmBasic.ThucHanh.MyGenericStack;

import static B6_DataStructuresAndAlgorithmBasic.ThucHanh.MyGenericStack.MyGenericStack.stackOfIStrings;
import static B6_DataStructuresAndAlgorithmBasic.ThucHanh.MyGenericStack.MyGenericStack.stackOfIntegers;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }
}