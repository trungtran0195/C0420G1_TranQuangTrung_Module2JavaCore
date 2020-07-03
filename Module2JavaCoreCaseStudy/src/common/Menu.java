package common;

public class Menu {
    public static void displayMainMenu() {
        System.out.println("Menu");
        System.out.println("1. Add New Services");
        System.out.println("2. Show Services");
        System.out.println("3. Add New Customer");
        System.out.println("4. Show Information of Customer");
        System.out.println("5. Add New Booking");
        System.out.println("6. Show Information of Employee");
        System.out.println("7. Booking movie ticket 4D");
        System.out.println("8. Find Employee");
        System.out.println("9. Exit");
        System.out.println("Enter your choice");
    }

    public static void displayMenuAddNewServices() {
        System.out.println("Add New Service:");
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back to Menu");
        System.out.println("5. Exit");
    }

    public static void displayMenuShowServices() {
        System.out.println("-------Show services manu--------");
        System.out.println("1. Show all Villa" +
                "\n2. Show all House" +
                "\n3. Show all Room" +
                "\n4.Show all Villa not duplicate" +
                "\n5.Show all House not duplicate" +
                "\n6.Show all Room not duplicate" +
                "\n7. Back to Menu" +
                "\n8. Exit");
        System.out.println("please select one of the functions below : ");
    }

    public static void displayMenuBackToMain() {
        System.out.println("-------Enter to continue--------");
        ScannerUtils.scanner.nextLine();
    }

    public static void displayMenuBooking() {
        System.out.println("1.Booking Villa" +
                "\n2.Booking House" +
                "\n3.Booking Room");
        System.out.println("choice the booking service");
    }

    public static void displayMenuBookingMovieTicket4D() {
        System.out.println("-----Book 4D movie ticket------");
        System.out.println("1.Booking movie ticket" +
                "\n2.Show customer booking" +
                "\n3.Exit");
        System.out.println("choice the function");
    }

}
