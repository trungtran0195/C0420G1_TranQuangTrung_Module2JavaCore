package B9_SortingAlgorithms.BaiTap.InsertionSort;


import static B9_SortingAlgorithms.BaiTap.InsertionSort.InsertionSort.insertionSort;

public class Main {
    public static void main(String[] args) {
        int[] list = {12,30,25,10,31,15,40};
        insertionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
