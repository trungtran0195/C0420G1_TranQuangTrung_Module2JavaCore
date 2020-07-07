package CaseStudyDictionary.controller;

import CaseStudyDictionary.service.ScannerUtils;

import static CaseStudyDictionary.service.Menu.displayMainMenu;
import static CaseStudyDictionary.service.Menu.displayMenuBackToMain;

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
            case "lookup":
                DicController.defineWord();
                break;
            case "edit":
                DicController.editWord();
                break;
            case "drop":
                DicController.dropWord();
                break;
            case "export":
                WriteAndReadFile.outputWordToCsv();
                break;
            case "exit":
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
