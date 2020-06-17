package B6_DataStructuresAndAlgorithmBasic.BaiTap.ArrayList;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "john");
        Student b = new Student(2, "tim");
        Student c = new Student(3, "paul");
        Student d = new Student(4, "nguyen");
        Student e = new Student(5, "tran");
        Student f = new Student(5, "tran");

        MyList<Student> studentMyList = new MyList<>();
        MyList<Student> newStudentList = new MyList<>();

        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);
        studentMyList.add(f, 2);

//        for (int i = 0 ; i < studentMyList.size(); i++){
//            Student student = (Student) studentMyList.elements[i];
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//            System.out.println(studentMyList.indexOf(f));
//            System.out.println(studentMyList.contains(d));
//        }

        newStudentList = studentMyList.clone();
        for (int i = 0; i < studentMyList.size(); i++) {
            System.out.println(studentMyList.get(i).getName());
        }
    }
}
