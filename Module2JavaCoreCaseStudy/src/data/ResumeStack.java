package data;

import common.WriteAndReadCsv;
import model.Employee;

import java.util.ArrayList;
import java.util.Stack;

public class ResumeStack {

    public static Stack<Employee> getAllEmployee() {
        Stack<Employee> employeeList = new Stack<Employee>();
        ArrayList<Employee> employeeArrayList = WriteAndReadCsv.getEmployeeListFromCSV();
        for (Employee employee : employeeArrayList) {
            employeeList.push(employee);
        }

        return employeeList;
    }
}
