package B11_IOTextFile.BaiTap.studentManager;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        StudentManager test = new StudentManager(FileUtil.readCSVFile());


        for (Student student : test.getStudentList()) {
            System.out.println(student);
        }

        System.out.println("------------------------");
        FileUtil.writeCSVFile(new Student(11, "Hieu", "HCM", 21), true);

        test.setStudentList(FileUtil.readCSVFile());

        for (Student student : test.getStudentList()) {
            System.out.println(student);
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input ID: ");
            String id = scanner.nextLine();
            System.out.print("Input name: ");
            String name = scanner.nextLine();
            System.out.print("Input address: ");
            String address = scanner.nextLine();
            System.out.print("Input age: ");
            String age = scanner.nextLine();

            Student student_1 = new Student(Integer.parseInt(id), name, address, Integer.parseInt(age));
            test.addNewStudent(student_1);

        } catch (Exception e){
            System.out.println("error");
        }
    }
}
