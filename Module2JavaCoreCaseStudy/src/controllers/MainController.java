package controllers;

import common.ScannerUtils;

import static common.Menu.displayMainMenu;
import static common.Menu.displayMenuBackToMain;
import static controllers.BookingController.addNewBooking;
import static controllers.BookingController.ticketBooking4DMovie;
import static controllers.CustomerController.addNewCustomer;
import static controllers.CustomerController.showInfomationCustomer;
import static controllers.EmployeeController.findEmployeeFromResume;
import static controllers.EmployeeController.showInfomationEmployee;
import static controllers.ServiceController.addNewServices;
import static controllers.ServiceController.showService;

public class MainController {
    public static void main(String[] args) {
        processMain();
    }
    public static void processMain() {
        try {
            displayMainMenu();
            processMainManu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            backMainMenu();
        }
    }

    public static void processMainManu() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addNewServices();
                break;
            case "2":
                showService();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInfomationCustomer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInfomationEmployee();
                break;
            case "7":
                ticketBooking4DMovie();
                break;
            case "8":
                findEmployeeFromResume();
                break;
            case "9":
                System.exit(0);
            default:
                System.out.println("No choice! Please try again");
                backMainMenu();
        }
    }

    public static void backMainMenu() {
        displayMenuBackToMain();
        processMain();
    }
}
