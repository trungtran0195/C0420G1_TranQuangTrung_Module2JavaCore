package B12_BinaryFileAndSerialization.BaiTap.productManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProductManager{
    private static final String  filepath = "src\\B12_BinaryFileAndSerialization\\BaiTap\\productManager\\test.ts";

    static ArrayList<Product> productArrayList;

    static {
        productArrayList = new ArrayList<>();
    }

    public static void addNewProduct() {
        Product product = new Product();
        System.out.println("Enter product id:");
        product.setProductId(ScannerUtils.scanner.nextInt());

        ScannerUtils.scanner.nextLine();
        System.out.println("Enter product name:");
        product.setProductName(ScannerUtils.scanner.nextLine());

        System.out.println("Enter product manufacturer:");
        product.setProductManufacturer(ScannerUtils.scanner.nextLine());

        System.out.println("Enter product detail:");
        product.setDetail(ScannerUtils.scanner.nextLine());

        System.out.println("Enter product price:");
        product.setPrice(ScannerUtils.scanner.nextInt());

        try {
            outputProduct(product);
        } catch (IOException | ClassNotFoundException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void showProductList() {
        displayList(productArrayList);
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

    public static void searchProductByName() {
        String input = "";
        System.out.println("enter name you want to search for");
        input = ScannerUtils.scanner.nextLine();
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getProductName().contains(input)) {
                productArrayList.get(i).showInfo();
            }
        }
        System.out.println("press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

    public static void outputProduct(Product product) throws IOException, ClassNotFoundException {
        if(!Files.exists(Paths.get(filepath))){
            Files.createFile(Paths.get(filepath));
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oo = new ObjectOutputStream(fos);
            productArrayList.add(product);
            oo.writeObject(productArrayList);
        }else {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream o = new ObjectInputStream(fis);
            ArrayList<Product> l = (ArrayList<Product>) o.readObject();
            productArrayList.addAll(l);
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oo = new ObjectOutputStream(fos);
            productArrayList.add(product);
            oo.writeObject(productArrayList);
        }
        System.out.println("product saved! Press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
    }

    public static void inputProduct() throws ClassNotFoundException, IOException {
        FileInputStream fis =  new FileInputStream(filepath);
        ObjectInputStream o = new ObjectInputStream(fis);
        ArrayList<Product> l= (ArrayList<Product>)o.readObject();
        for (int i = 0; i < l.size(); i++)
            System.out.println(l.get(i).getProductName());
        System.out.println("list product open! Press any button back to menu");
        ScannerUtils.scanner.nextLine();
        MainManu.processMain();
        }

        public static <E> void displayList(ArrayList<E> list) {
            int i = 1;
            System.out.println("--------list-------");
            for (E item : list) {
                ((Product) item).showInfo();
            }
            i++;
            System.out.println("------------------");
        }

}
