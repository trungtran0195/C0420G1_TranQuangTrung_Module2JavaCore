package B6_DataStructuresAndAlgorithmBasic.ThucHanh.MyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        // size = 0
        listInteger.add(1);
        // size = 1
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        // size = 5

        System.out.println("element 4: " + listInteger.get(4));
        System.out.println("element 1: " + listInteger.get(1));
        System.out.println("element 2: " + listInteger.get(2));

//        System.out.println("element 6: " + listInteger.get(6));

        MyList<Integer> listInteger2 = listInteger.clone();
        System.out.println(listInteger2.get(4));
        listInteger2.add(6);
        System.out.println("List 2: " + listInteger2.get(5));
        System.out.println("List 1: " + listInteger.get(5));


        // Convert list to array
        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("a");
        listStr.add("b");
        String[] str = listStr.toArray(new String[listStr.size()]);

        // Convert array list to array
        List<String> listStr2 = Arrays.asList(str);
    }
}
