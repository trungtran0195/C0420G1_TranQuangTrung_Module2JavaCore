package B11_IOTextFile.BaiTap.readAndCopyTextFile;

import java.io.*;

public class ReadAndCopyTextFile {
    public void readFile(String filePath, StringBuffer line){
        try{
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            line.append(br.readLine());
            System.out.println(line);
            br.close();
        }catch (Exception e){
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }

    public void writeFile(String filePath, StringBuffer line){
        try{
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            System.out.println("nội dung sẽ nhập vào :" +line.toString());
            BufferedWriter br = new BufferedWriter((new FileWriter(file)));
            br.write(line.toString());

            br.close();
        }catch (Exception e){
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }

    public static void main(String[] args) {
        StringBuffer line = new StringBuffer();
        String pathIn = "C:\\Users\\ADMIN\\Desktop\\in.txt";

        ReadAndCopyTextFile readfileIn = new ReadAndCopyTextFile();
        readfileIn.readFile(pathIn,line);


        String pathOut = "C:\\Users\\ADMIN\\Desktop\\out.txt";

        ReadAndCopyTextFile readFileOut = new ReadAndCopyTextFile();
        readFileOut.writeFile(pathOut, line);


    }
}
