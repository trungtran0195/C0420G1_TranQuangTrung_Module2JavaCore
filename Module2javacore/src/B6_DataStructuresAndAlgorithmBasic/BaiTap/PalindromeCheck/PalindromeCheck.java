package B6_DataStructuresAndAlgorithmBasic.BaiTap.PalindromeCheck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheck {
    public static void main(String args[]) {
        String str = "Able was I ere I saw Elba";
        Stack<String> wStack  = new Stack<>();
        Queue<String> wQueue = new LinkedList<String>();
        String[] firstLine = str.toLowerCase().split("");
        String[] secondLine = str.toLowerCase().split("");
        for (int i = 0; i < firstLine.length; i++) {
            wStack.push(firstLine[i]);
        }
        for (int i = 0; i < secondLine.length; i++) {
            wQueue.add(secondLine[i]);
        }
        int k = 0;
        int f = 0;
        while (!wQueue.isEmpty()){
            firstLine[k++] = String.valueOf(wStack.pop());
            secondLine[f++] = String.valueOf(wQueue.remove());
        }
        boolean result = true;
       for (int i = 0 ; i < firstLine.length; i++){
           if (!firstLine[i].equals(secondLine[i])) {
               result = false;
           }
       }
       if (result){
           System.out.println("is a palindrome");
       }else System.out.println("not a palindrome");
    }
}
