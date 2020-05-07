package CaseStudyJavaCore.Controllers;

import CaseStudyJavaCore.Commons.FuncGeneric;
import CaseStudyJavaCore.Commons.FuncWriteAndReadFileCSV;
import CaseStudyJavaCore.Commons.ScannerUtils;
import CaseStudyJavaCore.Models.Customer;
import CaseStudyJavaCore.Models.House;
import CaseStudyJavaCore.Models.Room;
import CaseStudyJavaCore.Models.Villa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static CaseStudyJavaCore.Commons.FuncGeneric.displayList;
import static CaseStudyJavaCore.Commons.Menu.displayMenuBookingMovieTicket4D;
import static CaseStudyJavaCore.Controllers.MainController.backMainMenu;
import static CaseStudyJavaCore.Commons.Menu.displayMenuBooking;

public class BookingController {

    private static Queue<Customer> customerQueueBookingTicket =  new LinkedList<Customer>();

    //add new booking
    public static void addNewBooking() {
        ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
        displayList(customerList);
        System.out.println("---choice one customer to booking");
        Customer customer = new Customer();
        customer = customerList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
        displayMenuBooking();
        processMenuBooking(customer);

        //get list customer from csv
        ArrayList<Customer> listBooking = FuncWriteAndReadFileCSV.getBookingFromCSV();
        //add customer to list
        listBooking.add(customer);
        //write to csv
        FuncWriteAndReadFileCSV.writeBookingToFileCsv(listBooking);
        System.out.println("---add booking for:" + customer.getFullName() + "---successfully!");
        backMainMenu();
    }

    private static void processMenuBooking(Customer customer) {
        switch (ScannerUtils.scanner.nextLine()){
            case "1":
                ArrayList<Villa> villaList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);
                displayList(villaList);
                System.out.println("---Choice villa booking");
                Villa villa =  villaList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(villa);
                break;
            case "2":
                ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);
                displayList(houseList);
                System.out.println("---Choice house booking");
                House house =  houseList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(house);
                break;
            case "3":
                ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);
                displayList(roomList);
                System.out.println("---Choice room booking");
                Room room =  roomList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(room);
                break;
            default:
                backMainMenu();
                break;
        }
    }

    public static void ticketBooking4DMovie () {
        displayMenuBookingMovieTicket4D();
        processMenuBookingMovieTicket4D();
        }

    private static void processMenuBookingMovieTicket4D() {
        switch (ScannerUtils.scanner.nextLine()) {
                case "1":
                    addBookingMovieTicket4D();
                    break;
                case "2":
                    showBookingMovieTicket();
                    break;
                case "3":
                    System.exit(0);;
                    break;
                default:
                    System.out.println("Error! back to menu");
                    backMainMenu();
    }


}

    private static void showBookingMovieTicket() {
        int i = 1;
        System.out.println("---------------List----------------");
        for (Customer customer : customerQueueBookingTicket){
            System.out.println("No:" +1);
            customer.showInfo();
            i++;
            System.out.println("--------------------------------");
        }
        backMainMenu();
    }

    private static void addBookingMovieTicket4D() {
        //lua chon customer booking ticket
        try {
            ArrayList<Customer> customerList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.CUSTOMER);
            displayList(customerList);
            System.out.println("---choice one customer to booking");
            Customer customer = new Customer();
            customer = customerList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
            customerQueueBookingTicket.add(customer);
            System.out.println("---add booking for:" + customer.getFullName() + "---successfully!");
        }catch (IndexOutOfBoundsException ex){
            System.out.println("No customer to book 4D Ticket!! Please try again");
            addBookingMovieTicket4D();
        }
        backMainMenu();
    }

}
