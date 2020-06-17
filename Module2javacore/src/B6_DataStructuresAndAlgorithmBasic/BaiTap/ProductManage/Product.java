package B6_DataStructuresAndAlgorithmBasic.BaiTap.ProductManage;

import java.util.Comparator;

public class Product{
    private int id;
    private String nameProduct;
    private int price;

    public Product() {
    }

    public Product(int id, String nameProduct, int price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Comparator<Product> ProductPriceSort = new Comparator<Product>(){
        public int compare(Product p1, Product p2){
            int priceno1 = p1.getPrice();
            int priceno2 = p2.getPrice();
            return priceno1 - priceno2;
        }
    };

    public void showInfo() {
        System.out.println("id :" + id +
                " name product:" + nameProduct +
                " product price: " + price);
    }

}
