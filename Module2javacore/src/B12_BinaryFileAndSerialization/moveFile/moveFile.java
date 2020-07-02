package B12_BinaryFileAndSerialization.moveFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class moveFile {
    public static void main(String[] args) {
        String filepathIn = "C:\\Users\\ADMIN\\Desktop\\product.dat";
        String filepathOut = "C:\\Users\\ADMIN\\Desktop\\product.dat";

        try {
            FileOutputStream fileOut = new FileOutputStream(filepathOut);
            FileOutputStream fileIn = new FileOutputStream(filepathIn);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
