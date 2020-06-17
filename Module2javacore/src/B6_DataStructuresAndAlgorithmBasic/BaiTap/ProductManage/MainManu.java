package B6_DataStructuresAndAlgorithmBasic.BaiTap.ProductManage;

import static B6_DataStructuresAndAlgorithmBasic.BaiTap.ProductManage.LinkedListProduct.*;

public class MainManu {
    public static void main(String[] args) {
        processMain();
    }
    public static void processMain() {
        try {
            displayMainMenu();
            processMainManu();
        }catch (Exception e){
            processMain();
        }
    }

    public static void displayMainMenu() {
        System.out.println("Menu");
        System.out.println("Add new product");
        System.out.println("Edit product");
        System.out.println("Delete product");
        System.out.println("Search name product");
        System.out.println("List product");
        System.out.println("Sort product based on price");
    }

    public static void processMainManu() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addNewProduct();
                break;
            case "2":
                editProduct();
                break;
            case "3":
                deleteProduct();
                break;
            case "4":
                showProductList();
                break;
            case "5":
                searchProductByName();
                break;
            case "6":
                sortByPriceProduct();
                break;
            default:
                displayMainMenu();
        }
    }
}