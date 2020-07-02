package B11_IOTextFile.BaiTap.studentManager;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    List<Student> studentList;

    public StudentManager(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentManager() {
        studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public boolean addNewStudent(Student student) {
        if (student != null) {
            return this.studentList.add(student);
        }
        return false;
    }

    public void updateStudent(Student student) {
        if (studentList.contains(student)) {
            studentList.remove(student);
            studentList.add(student);
        } else {
            studentList.add(student);
        }

    }

    @Override
    public String toString() {
        return "StudentManager{" +
                "studentList=" + studentList +
                '}';
    }

}
