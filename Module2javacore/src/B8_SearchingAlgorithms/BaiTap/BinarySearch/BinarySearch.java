package B8_SearchingAlgorithms.BaiTap.BinarySearch;

public class BinarySearch {
    public int search(int searchArray[], int leftSide , int rightSide, int findNum){
        if (rightSide >= leftSide){
            int midPoint = leftSide + (rightSide - leftSide) /2;

            if (searchArray[midPoint] == findNum){
                return midPoint;
            }

            if (searchArray[midPoint] > findNum){
                return search(searchArray, leftSide,midPoint -1 , findNum);
            }

            return search(searchArray, midPoint +1, rightSide,findNum);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int searchArray[] = {2, 3, 4, 10, 40};
        int findNum = 10;
        int result = binarySearch.search(searchArray,0,searchArray.length,findNum);
        if (result == -1){
            System.out.println("khong tim thay phan tu" +findNum);
        }else System.out.println("phan tu" +findNum + "duoc tim thay tai vi tri" + result);
    }
}
