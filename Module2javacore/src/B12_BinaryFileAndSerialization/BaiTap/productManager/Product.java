package B12_BinaryFileAndSerialization.BaiTap.productManager;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer productId;
    private String productName;
    private String productManufacturer;
    private Integer price;
    private String detail;

    public Product() {
    }

    public Product(Integer productId, String productName, String productManufacturer, Integer price, String detail) {
        this.productId = productId;
        this.productName = productName;
        this.productManufacturer = productManufacturer;
        this.price = price;
        this.detail = detail;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void showInfo() {
        System.out.println("Product ID: " +productId+
                "\n ProductName: " +productName+
                "\n Manufacturer: " +productManufacturer+
                "\n Price: "+price+
                "\n Product Detail: "+detail);
    }
}
