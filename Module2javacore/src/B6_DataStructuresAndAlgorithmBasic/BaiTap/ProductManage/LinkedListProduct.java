package B6_DataStructuresAndAlgorithmBasic.BaiTap.ProductManage;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListProduct {
    static LinkedList<Product> productLinkedList;

    static {
        productLinkedList = new LinkedList<>();
        productLinkedList.addLast(new Product(1, "apple", 10000));
        productLinkedList.addLast(new Product(2, "orange", 5000));
        productLinkedList.addLast(new Product(3, "milk", 30000));
        productLinkedList.addLast(new Product(4, "pork", 100000));
        productLinkedList.addLast(new Product(5, "chicken", 150000));
        productLinkedList.addLast(new Product(6, "beef", 50000));
        productLinkedList.addLast(new Product(7, "cabbage", 15000));
    }

    public static void addNewProduct(){
        Product product = new Product();
        System.out.println("Enter product id:");
        product.setId(ScannerUtils.scanner.nextInt());

        ScannerUtils.scanner.nextLine();
        System.out.println("Enter product name:");
        product.setNameProduct(ScannerUtils.scanner.nextLine());

        System.out.println("Enter product price:");
        product.setPrice(ScannerUtils.scanner.nextInt());
        productLinkedList.addLast(product);

        MainManu.processMain();
    }

    public static void editProduct(){
        for (int i = 0 ; i < productLinkedList.size(); i++){
            Product product = (Product) productLinkedList.get(i);
            System.out.println(product.getNameProduct());
        }
        int input = 0;
        Product product = new Product();

        System.out.println("Enter product you want to edit");
        input = ScannerUtils.scanner.nextInt();

        System.out.print("Enter product id:");
        product.setId (ScannerUtils.scanner.nextInt());

        ScannerUtils.scanner.nextLine();
        System.out.print("Enter product name:");
        product.setNameProduct (ScannerUtils.scanner.nextLine());

        ScannerUtils.scanner.nextInt();
        System.out.println("Enter product price:");
        product.setPrice(ScannerUtils.scanner.nextInt());

        productLinkedList.set(input,product);

        MainManu.processMain();
    }

    public static void showProductList(){
        for (int i = 0 ; i < productLinkedList.size(); i++){
            Product product = (Product) productLinkedList.get(i);
            System.out.println(product.getNameProduct());
        }

        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();

    }

    public static void deleteProduct(){
        for (int i = 0 ; i < productLinkedList.size(); i++){
            Product product = (Product) productLinkedList.get(i);
            System.out.println(product.getNameProduct());
        }
        int input = 0;
        System.out.println("Enter product you want to delete");
        input = ScannerUtils.scanner.nextInt();
        productLinkedList.removeLastOccurrence(input);
        MainManu.processMain();
    }

    public static void searchProductByName(){
        String input = "";
        System.out.println("enter name you want to search for");
        input = ScannerUtils.scanner.nextLine();
        for (int i = 0 ; i<  productLinkedList.size(); i++){
            if (productLinkedList.get(i).getNameProduct().contains(input)){
                productLinkedList.get(i).showInfo();
            }
        }
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

    public static void sortByPriceProduct(){
        Collections.sort(productLinkedList, Product.ProductPriceSort);
        for (int i = 0 ; i < productLinkedList.size(); i++){
            Product product = (Product) productLinkedList.get(i);
            System.out.println(product.getNameProduct() + product.getPrice());
        }
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

}
