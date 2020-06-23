package B9_SortingAlgorithms.ThucHanh.SelectionSort;

import static B9_SortingAlgorithms.ThucHanh.SelectionSort.SelectionSort.selectionSort;

public class Main {
    public static void main(String[] args) {
        double[] list = {2,4,7,6,1,9,3,5,8};
        selectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
