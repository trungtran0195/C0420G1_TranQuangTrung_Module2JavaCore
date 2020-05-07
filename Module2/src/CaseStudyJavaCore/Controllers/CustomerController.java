package CaseStudyJavaCore.Controllers;

import CaseStudyJavaCore.Commons.FuncGeneric;
import CaseStudyJavaCore.Commons.FuncValidation;
import CaseStudyJavaCore.Commons.FuncWriteAndReadFileCSV;
import CaseStudyJavaCore.Commons.ScannerUtils;
import CaseStudyJavaCore.Models.Customer;
import CaseStudyJavaCore.Models.SortNameAndYear;

import java.util.ArrayList;

import static CaseStudyJavaCore.Commons.FuncGeneric.displayList;
import static CaseStudyJavaCore.Controllers.MainController.backMainMenu;

public class CustomerController {
    public static final String ENTER_CUSTOMER_NAME = "Enter customer name:";
    public static final String INVALID_CUSTOMER_NAME = "Customer name is invalid , customer name each first letter must be a capitalized word";
    public static final String ENTER_GENDER = "Enter customer gender:";
    public static final String INVALID_GENDER = "Gender info is invalid , gender is either : male,female,unknown";
    public static final String ENTER_ID_CARD = "Enter id number:";
    public static final String INVALID_ID_CARD = "id number invalid. ID card must have 9 digits in order : XXX XXX XXX";
    public static final String ENTER_EMAIL ="Enter customer email:";
    public static final String INVALID_EMAIL = "Email info is invalid . Email format is abc@abc.com";
    public static final String ENTER_BIRTHDAY = "Enter customer DoB:";
    public static final String INVALID_BIRTHDAY =  "Invalid birthday info. Birthday format is dd/mm/yyyy and year must be over 1900 and under 2020";
    //add new customer
    public static void addNewCustomer(){
        Customer customer = new Customer();

        //set customer full name
        System.out.println("Enter customer full name:");
        customer.setFullName(FuncValidation.getValidCustomerName(ENTER_CUSTOMER_NAME,INVALID_CUSTOMER_NAME));

        //set birthday customer
        System.out.println("Enter customer date of birth: ");
        customer.setBirthday(FuncValidation.getValidBirthday(ENTER_BIRTHDAY,INVALID_BIRTHDAY));

        //set gender
        System.out.println("Enter customer gender: ");
        String gender = FuncValidation.getValidGender(ENTER_GENDER,INVALID_GENDER);
        customer.setGender(Character.toUpperCase(gender.charAt(0)) + gender.substring(1,gender.length()).toLowerCase());

        //set customer idCard
        System.out.println("Enter customer id card: ");
        customer.setIdCard(FuncValidation.getValidIdCard(ENTER_ID_CARD,INVALID_ID_CARD));

        //set customer Phone
        System.out.println("Enter customer phone: ");
        customer.setPhone(ScannerUtils.scanner.nextLine());

        //set customer Email
        customer.setEmail(FuncValidation.getValidEmail(ENTER_EMAIL,INVALID_EMAIL));

        //set type Customer
        System.out.println("Enter type customer:");
        customer.setCustomerType(ScannerUtils.scanner.nextLine());

        //set customer address
        System.out.println("Enter customer address:");
        customer.setAddress(ScannerUtils.scanner.nextLine());

        //get list customer from CSV
        ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        //Add customer to list
        customerList.add(customer);
        //write csv
        FuncWriteAndReadFileCSV.writeCustomerToFileCsv(customerList);

        System.out.println("---add customer:" + customer.getFullName() + "----");
        backMainMenu();
    }
    //show customer detail
    public static void showInfomationCustomer(){
        ArrayList<Customer> customerList =  FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        //sap xep theo thu tu alphabet full name , truong hop customer nao trung ten thi sap xep theo birthday
        customerList.sort(new SortNameAndYear());
        displayList(customerList);
        backMainMenu();
    }
}
