package B6_DataStructuresAndAlgorithmBasic.BaiTap.ProductManage;

import java.util.ArrayList;
import java.util.Collections;

public class ProductManager {
    static ArrayList<Product> productArrayList;

    static {
        productArrayList = new ArrayList<>();
        productArrayList.add(0,new Product(1, "apple", 10000));
        productArrayList.add(1,new Product(2, "orange", 5000));
        productArrayList.add(2,new Product(3, "milk", 30000));
        productArrayList.add(3,new Product(4, "pork", 100000));
        productArrayList.add(4,new Product(5, "chicken", 150000));
        productArrayList.add(5,new Product(6, "beef", 50000));
        productArrayList.add(6,new Product(7, "cabbage", 15000));
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
        productArrayList.add(product);
        MainManu.processMain();
    }

    public static void editProduct(){
        int input = 0;
        Product product = new Product();
        displayList(productArrayList);

        System.out.println("Enter product you want to edit");
        input = ScannerUtils.scanner.nextInt()-1;

        System.out.print("Enter product id:");
        product.setId (ScannerUtils.scanner.nextInt());

        ScannerUtils.scanner.nextLine();
        System.out.print("\nEnter product name:");
        product.setNameProduct (ScannerUtils.scanner.nextLine());

        System.out.println("Enter product price:");
        product.setPrice(ScannerUtils.scanner.nextInt());

        productArrayList.set(input,product);

        MainManu.processMain();
    }

    public static void showProductList(){
        displayList(productArrayList);
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

    public static void deleteProduct(){
        int input = 0;
        productArrayList.toArray();
        System.out.println("Enter product you want to delete");
        input = ScannerUtils.scanner.nextInt()-1;
        productArrayList.remove(input);
        MainManu.processMain();
    }

    public static void searchProductByName(){
        String input = "";
        System.out.println("enter name you want to search for");
        input = ScannerUtils.scanner.nextLine();
        for (int i = 0 ; i<  productArrayList.size(); i++){
           if (productArrayList.get(i).getNameProduct().contains(input)){
               productArrayList.get(i).showInfo();
           }
       }
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

    public static void sortByPriceProduct(){
        Collections.sort(productArrayList, Product.ProductPriceSort);
        displayList(productArrayList);
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }


    public static <E> void displayList(ArrayList<E> list){
        int i = 1;
        System.out.println("--------list-------");
        for (E item : list) {
            ((Product) item).showInfo();
        }
        i++;
        System.out.println("------------------");
    }
}
