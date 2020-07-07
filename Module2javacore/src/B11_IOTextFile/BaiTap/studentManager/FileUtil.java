package B11_IOTextFile.BaiTap.studentManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static final String FILE_PATH = "src\\B11_IOTextFile\\BaiTap\\studentManager\\input.csv";
    public static final String COMMA = ",";

    public static List<Student> readCSVFile() {
        BufferedReader bufferedReader = null;
        List<Student> studentList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            Student student;
            String[] arrStr;
            while ((line = bufferedReader.readLine()) != null) {
                arrStr = line.split(",");
                student = new Student(Integer.parseInt(arrStr[0]), arrStr[1], arrStr[2], Integer.parseInt(arrStr[3]));
                studentList.add(student);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void writeCSVFile(Student student, boolean append){
        if(student == null) return;

        BufferedWriter bufferedWriter = null;

        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH,append);
            bufferedWriter = new BufferedWriter(fileWriter);

            StringBuffer buffer = new StringBuffer();
            buffer.append(student.getId()).append(COMMA);
            buffer.append(student.getName()).append(COMMA);

            
            buffer.append(student.getAddress()).append(COMMA);
            buffer.append(student.getAge()).append(COMMA);

            bufferedWriter.write(buffer.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
