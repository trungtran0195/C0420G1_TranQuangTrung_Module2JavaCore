package controllers;

import common.ScannerUtils;
import common.WriteAndReadCsv;
import model.Customer;
import model.House;
import model.Room;
import model.Villa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static common.GeneralFunction.displayList;
import static common.Menu.displayMenuBooking;
import static common.Menu.displayMenuBookingMovieTicket4D;
import static controllers.MainController.backMainMenu;

public class BookingController {

    private static Queue<Customer> customerQueueBookingTicket = new LinkedList<Customer>();

    public static void addNewBooking() {
        ArrayList<Customer> customerList = WriteAndReadCsv.getCustomerListFromCSV();
        displayList(customerList);
        System.out.println("---choice one customer to booking");
        Customer customer = new Customer();
        customer = customerList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
        displayMenuBooking();
        processMenuBooking(customer);

        ArrayList<Customer> listBooking = new ArrayList<>();
        listBooking.add(customer);

        WriteAndReadCsv.writeBookingToFileCsv(listBooking,true);
        backMainMenu();
    }

    private static void processMenuBooking(Customer customer) {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                ArrayList<Villa> villaList = WriteAndReadCsv.getVillaListFromCSV();
                displayList(villaList);
                System.out.println("---Choice villa booking");
                Villa villa = villaList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(villa);
                break;
            case "2":
                ArrayList<House> houseList = WriteAndReadCsv.getHouseListFromCSV();
                displayList(houseList);
                System.out.println("---Choice house booking");
                House house = houseList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(house);
                break;
            case "3":
                ArrayList<Room> roomList = WriteAndReadCsv.getRoomListFromCSV();
                displayList(roomList);
                System.out.println("---Choice room booking");
                Room room = roomList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
                customer.setServices(room);
                break;
            default:
                backMainMenu();
                break;
        }
    }

    public static void ticketBooking4DMovie() {
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
                System.exit(0);
                ;
                break;
            default:
                System.out.println("Error! back to menu");
                backMainMenu();
        }
    }

    private static void showBookingMovieTicket() {
        int i = 1;
        System.out.println("---------------List----------------");
        for (Customer customer : customerQueueBookingTicket) {
            System.out.println("No:" + 1);
            customer.showInfo();
            i++;
            System.out.println("--------------------------------");
        }
        backMainMenu();
    }

    private static void addBookingMovieTicket4D() {
        try {
            ArrayList<Customer> customerList = WriteAndReadCsv.getCustomerListFromCSV();
            displayList(customerList);
            System.out.println("---choice one customer to booking");
            Customer customer = new Customer();
            customer = customerList.get(Integer.parseInt(ScannerUtils.scanner.nextLine()) - 1);
            customerQueueBookingTicket.add(customer);
            System.out.println("---add booking for:" + customer.getFullName() + "---successfully!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("No customer to book 4D Ticket!! Please try again");
            addBookingMovieTicket4D();
        }
        backMainMenu();
    }
}
