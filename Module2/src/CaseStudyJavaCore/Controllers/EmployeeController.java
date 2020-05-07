package CaseStudyJavaCore.Controllers;

import CaseStudyJavaCore.Commons.FuncGeneric;
import CaseStudyJavaCore.Commons.ScannerUtils;
import CaseStudyJavaCore.Data.Resume;
import CaseStudyJavaCore.Models.Employee;

import java.util.*;

import static CaseStudyJavaCore.Controllers.MainController.backMainMenu;

public class EmployeeController {
    //show employee info
    public static void showInfomationEmployee(){
        ArrayList<Employee> employeeList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.EMPLOYEE);
        Map<String,  Employee> map = new HashMap<>();
        for (Employee employee : employeeList){
            map.put(employee.getId(), employee);
        }
        displayMap(map);
        backMainMenu();
    }

    private static void displayMap(Map<String, Employee> map) {
        for (Map.Entry m : map.entrySet()) {
            System.out.println("Key:" + m.getKey() + "\n" + m.getValue().toString());
        }
    }

    //find employee
    public static void findEmployeeFromResume(){
        Stack<Employee> employeeStack = Resume.getAllEmployee();
        System.out.println("Enter key of employee:");
        String inputSearch = ScannerUtils.scanner.nextLine();
        try {
            while (true){
                boolean foundById = employeeStack.peek().getId().contains(inputSearch);
                if (!foundById) {
                    employeeStack.pop();
                }else {
                    System.out.println("---found employee below---");
                    System.out.println(employeeStack.peek().toString());
                     break;
                }
            }
        }catch (EmptyStackException ex){
            System.out.println("Key invalid!! please try again");
            findEmployeeFromResume();
        }
        backMainMenu();
    }
}
