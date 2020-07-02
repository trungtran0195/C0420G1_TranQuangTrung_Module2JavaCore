package B12_BinaryFileAndSerialization.BaiTap.productManager;

import java.io.IOException;

import static B12_BinaryFileAndSerialization.BaiTap.productManager.ProductManager.*;

public class MainManu {
    public static void main(String[] args) {
        processMain();
    }
    public static void processMain() {
        displayMainMenu();
        processMainManu();
    }

    public static void displayMainMenu() {
        System.out.println("Menu");
        System.out.println("1.Add new product");
        System.out.println("2.Search name product");
        System.out.println("3.List product");
        System.out.println("4.Open product list");
    }

    public static void processMainManu() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addNewProduct();
                break;
            case "2":
                searchProductByName();
                break;
            case "3":
                showProductList();
                break;
            case "4":
                try {
                    inputProduct();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            default:
                processMain();
        }
    }
}