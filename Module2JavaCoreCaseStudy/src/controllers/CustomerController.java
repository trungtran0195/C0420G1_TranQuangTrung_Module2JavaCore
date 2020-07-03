package controllers;

import common.ScannerUtils;
import common.Validation;
import common.WriteAndReadCsv;
import model.Customer;
import model.SortNameAndYear;

import java.util.ArrayList;

import static common.GeneralFunction.displayList;
import static controllers.MainController.backMainMenu;

public class CustomerController {
    public static final String ENTER_CUSTOMER_NAME = "Enter customer name:";
    public static final String INVALID_CUSTOMER_NAME = "Customer name is invalid , customer name each first letter must be a capitalized word";
    public static final String ENTER_GENDER = "Enter customer gender:";
    public static final String INVALID_GENDER = "Gender info is invalid , gender is either : male,female,unknown";
    public static final String ENTER_ID_CARD = "Enter id number:";
    public static final String INVALID_ID_CARD = "id number invalid. ID card must have 9 digits in order : XXX XXX XXX";
    public static final String ENTER_EMAIL = "Enter customer email:";
    public static final String INVALID_EMAIL = "Email info is invalid . Email format is abc@abc.com";
    public static final String ENTER_BIRTHDAY = "Enter customer birthday:";
    public static final String INVALID_BIRTHDAY = "Invalid birthday info. Birthday format is dd/mm/yyyy and year must be over 1900 and under 2020";

    //add new customer
    public static void addNewCustomer() {
        Customer customer = new Customer();

        //set customer full name
        customer.setFullName(Validation.getValidCustomerName(ENTER_CUSTOMER_NAME, INVALID_CUSTOMER_NAME));

        //set birthday customer
        customer.setBirthday(Validation.getValidBirthday(ENTER_BIRTHDAY, INVALID_BIRTHDAY));

        //set gender
        String gender = Validation.getValidGender(ENTER_GENDER, INVALID_GENDER);
        customer.setGender(Character.toUpperCase(gender.charAt(0)) + gender.substring(1, gender.length()).toLowerCase());

        //set customer idCard
        customer.setIdCard(Validation.getValidIdCard(ENTER_ID_CARD, INVALID_ID_CARD));

        //set customer Phone
        System.out.println("Enter customer phone: ");
        customer.setPhone(ScannerUtils.scanner.nextLine());

        //set customer Email
        customer.setEmail(Validation.getValidEmail(ENTER_EMAIL, INVALID_EMAIL));

        //set type Customer
        System.out.println("Enter type customer:");
        customer.setCustomerType(ScannerUtils.scanner.nextLine());

        //set customer address
        System.out.println("Enter customer address:");
        customer.setAddress(ScannerUtils.scanner.nextLine());

        WriteAndReadCsv.writeCustomerToFileCsv(customer,true);
        backMainMenu();
    }

    public static void showInfomationCustomer() {
        ArrayList<Customer> customerList = WriteAndReadCsv.getCustomerListFromCSV();
        customerList.sort(new SortNameAndYear());
        displayList(customerList);
        backMainMenu();
    }
}
