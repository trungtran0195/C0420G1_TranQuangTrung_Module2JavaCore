package B12_BinaryFileAndSerialization.BaiTap.ProductManager;

import java.io.*;
import java.util.ArrayList;

public class ProductManager implements Serializable {
    static ArrayList<Product> productArrayList;

    static {
        productArrayList = new ArrayList<>();
        productArrayList.add(0,new Product(1,"nokia n1","nokia",1000000,"old"));
        productArrayList.add(1,new Product(2,"iphone X","apple",10000000,"new"));
        productArrayList.add(2,new Product(3,"samsung note 10","samsung",80000000,"old"));
        productArrayList.add(3,new Product(4,"iphone XS","apple",15000000,"new"));
        productArrayList.add(4,new Product(5,"oneplus 8","oneplus",7000000,"new"));
    }

    public static void addNewProduct(){
        Product product = new Product();
        System.out.println("Enter product id:");
        product.setProductId(ScannerUtils.scanner.nextInt());

        ScannerUtils.scanner.nextLine();
        System.out.println("Enter product name:");
        product.setProductName(ScannerUtils.scanner.nextLine());

        System.out.println("Enter product manufacturer:");
        product.setProductManufacturer(ScannerUtils.scanner.nextLine());

        System.out.println("Enter product price:");
        product.setPrice(ScannerUtils.scanner.nextInt());

        System.out.println("Enter product detail:");
        product.setDetail(ScannerUtils.scanner.nextLine());
    }

    public static void showProductList(){
        displayList(productArrayList);
    }

    public static void searchProductByName(){
        String input = "";
        System.out.println("enter name you want to search for");
        input =  ScannerUtils.scanner.nextLine();
        for (int i = 0 ; i<  productArrayList.size(); i++){
            if (productArrayList.get(i).getProductName().contains(input)){
                productArrayList.get(i).showInfo();
            }
        }
    }

    public static void outputProduct() throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("productout.dat"));
        ){
            for (int i = 0 ; i < productArrayList.size(); i++){
                output.writeInt(productArrayList.get(i).getProductId());
                output.writeUTF(productArrayList.get(i).getProductName());
                output.writeUTF(productArrayList.get(i).getProductManufacturer());
                output.writeInt(productArrayList.get(i).getPrice());
                output.writeUTF(productArrayList.get(i).getDetail());
            }
        }
    }

    public static void inputProduct() throws ClassNotFoundException,IOException{
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("productin.dat"))){

        }
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
