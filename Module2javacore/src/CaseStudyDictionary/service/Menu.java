package CaseStudyDictionary.service;

public class Menu {
    public static void displayMainMenu() {
        System.out.println("Menu");
        System.out.println("1. lookup");
        System.out.println("2. edit");
        System.out.println("3. drop");
        System.out.println("4. export");
        System.out.println("5. Exit");
        System.out.println("Enter your choice");
    }

    public static void displayMenuBackToMain() {
        System.out.println("-------Enter to continue--------");
        ScannerUtils.scanner.nextLine();
    }
}
