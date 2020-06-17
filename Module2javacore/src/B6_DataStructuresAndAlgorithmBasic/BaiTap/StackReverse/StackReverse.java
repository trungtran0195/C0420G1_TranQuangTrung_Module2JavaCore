package B6_DataStructuresAndAlgorithmBasic.BaiTap.StackReverse;

import java.util.Stack;

public class StackReverse {
    public static void main(String args[]) {
        String str = "1 2 3 4 5 6";
        Stack<Integer> wStack  = new Stack<>();
        String[] mWord = str.split(" ");
        for (int i = 0; i < mWord.length; i++) {
            wStack.push(Integer.valueOf(mWord[i]));
        }
        int k = 0;
        while (!wStack.empty()){
            mWord[k++] = String.valueOf(wStack.pop());
        }
        for (int i = 0; i< mWord.length;i++){
            str = mWord[i];
            System.out.println(str);
        }
    }
}
