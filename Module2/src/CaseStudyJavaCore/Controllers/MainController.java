package CaseStudyJavaCore.Controllers;

import CaseStudyJavaCore.Commons.ScannerUtils;

import static CaseStudyJavaCore.Commons.Menu.displayMainMenu;
import static CaseStudyJavaCore.Commons.Menu.displayMenuBackToMain;
import static CaseStudyJavaCore.Controllers.BookingController.*;
import static CaseStudyJavaCore.Controllers.CustomerController.addNewCustomer;
import static CaseStudyJavaCore.Controllers.CustomerController.showInfomationCustomer;
import static CaseStudyJavaCore.Controllers.EmployeeController.*;
import static CaseStudyJavaCore.Controllers.ServiceController.addNewServices;
import static CaseStudyJavaCore.Controllers.ServiceController.showServices;

public class MainController {
    public static void processMain() {
        try {
            displayMainMenu();
            processMainManu();
        }catch (Exception e){
            backMainMenu();
        }
    }
    public static void processMainManu(){
            switch (ScannerUtils.scanner.nextLine()) {
                case "1":
                    addNewServices();
                    break;
                case "2":
                    showServices();
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
        public static void backMainMenu(){
            displayMenuBackToMain();
            processMain();
        }
    }