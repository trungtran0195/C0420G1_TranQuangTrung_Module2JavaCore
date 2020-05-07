package CaseStudyJavaCore.Controllers;


import CaseStudyJavaCore.Commons.FuncGeneric;
import CaseStudyJavaCore.Commons.FuncValidation;
import CaseStudyJavaCore.Commons.FuncWriteAndReadFileCSV;
import CaseStudyJavaCore.Commons.ScannerUtils;
import CaseStudyJavaCore.Models.House;
import CaseStudyJavaCore.Models.Room;
import CaseStudyJavaCore.Models.Services;
import CaseStudyJavaCore.Models.Villa;

import java.util.ArrayList;

import static CaseStudyJavaCore.Commons.FuncGeneric.displayList;
import static CaseStudyJavaCore.Commons.FuncGeneric.showAllNameNotDuplicate;
import static CaseStudyJavaCore.Commons.Menu.displayMenuAddNewServices;
import static CaseStudyJavaCore.Commons.Menu.displayMenuShowServices;
import static CaseStudyJavaCore.Controllers.MainController.backMainMenu;
import static CaseStudyJavaCore.Controllers.MainController.processMain;

public class ServiceController {

    public static final String ENTER_SERVICE_ID = "Enter service ID: ";
    public static final String INVALID_SERVICE_ID = "Service ID is invalid. Service ID mus be format SVXX-YYYY, Y : 0-9, XX : case Villa is VL, case House is HO, case Room is RO . Please try again !!!";
    public static final String ENTER_SERVICE_NAME = "Enter service Name: ";
    public static final String INVALID_SERVICE_NAME = "Service name is invalid. Service name must be capitalized with first letters, the following characters is normal characters. Please try again !!!";
    public static final String ENTER_AREA_USED = "Enter Area Used: ";
    public static final String INVALID_DOUBLE_NUMBER = "Area Used is invalid (Area > 30, Area must be a Double). Please try again!!!";
    public static final String ENTER_RENTAL_COSTS = "Enter Rental Costs: ";
    public static final String INVALID_RENTAL_COSTS = "Rental Costs is invalid (Costs > 0, Costs must be Double). Please try again!!!";
    public static final String ENTER_MAX_NUMBER_OF_PEOPLE = "Enter Max Number Of People: ";
    public static final String INVALID_MAX_PEOPLE = "Max Number Of People is invalid (Number Of People > 0 And Number Of People < 20, Number Of People must be Integer). Please try again!!!";
    public static final String ENTER_RENT_TYPE = "Enter Rent Type: ";
    public static final String INVALID_RENT_TYPE = "Rent Type is invalid. Rent Type must be capitalized with first letters, the following characters is normal characters. Please try again !!!";
    public static final String ENTER_ROOM_STANDARD = "Enter Room Standard: ";
    public static final String INVALID_ROOM_STANDARD = "Room Standard is invalid. Room Standard must be capitalized with first letters, the following characters is normal characters. Please try again !!!";
    public static final String ENTER_AREA_POOL = "Enter Area Pool: ";
    public static final String INVALID_AREA_POOL = "Area Pool is invalid (Area > 30, Area must be a Double). Please try again!!!";
    public static final String ENTER_NUMBER_OF_FLOORS = "Enter Number Of Floors: ";
    public static final String INVALID_NUMBER_FLOORS = "Number Of Floors is invalid (Number Of Floors > 0, Number Of Floors must be a Integer). Please try again!!!";
    public static final String ENTER_FREE_SERVICES = "Enter free services: ";
    public static final String INVALID_FREE_SERVICES = "Free Services must be equal massage, food, karaoke, drink or car. Please try again!!!";

    public static void addNewServices() {
        displayMenuAddNewServices();
        processMenuAddNewService();
    }
    public static void processMenuAddNewService() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                addNewVilla();
                break;
            case "2":
                addNewHouse();
                break;
            case "3":
                addNewRoom();
                break;
            case "4":
                processMain();
                System.out.println("\n---------------------------------------------");
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("--- Nhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }
    // Add New Villa
    public static void addNewVilla() {
        Services villa = new Villa();
        // Enter common property
        villa = addNewService(villa);

        //Enter Room Standard
        ((Villa) villa).setRoomStandard(FuncValidation.getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        // Enter Convenient Description
        System.out.println("Enter Convenient Description:");
        ((Villa) villa).setConvenientDescription(ScannerUtils.scanner.nextLine());

        // Enter Area Pool
        ((Villa) villa).setAreaPool(FuncValidation.getValidNumberDouble(ENTER_AREA_POOL, INVALID_AREA_POOL, 30.0));

        // Enter Number Of Floors
        ((Villa) villa).setNumberOfFloors(FuncValidation.getValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_FLOORS, 0));

        // Get list Villa from CSV
        ArrayList<Villa> villaList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);
        // Add villa to list
        villaList.add((Villa) villa);
        // Write to CSV
        FuncWriteAndReadFileCSV.writeVillaToFileCsv(villaList);

        System.out.println("--- Add Villa: " + villa.getServiceName() + " Successfully");

        backMainMenu();
    }

    //Add New House
    private static void addNewHouse() {
        Services house = new House();

        // Enter common property
        house = addNewService(house);

        //Set Room Standard
        ((House) house).setRoomStandard(FuncValidation.getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        //Enter Description
        System.out.println("Enter Convenient Description: ");
        ((House) house).setConvenientDescription(ScannerUtils.scanner.nextLine());

        // Enter Number Of Floors
        ((House) house).setNumberOfFloors(FuncValidation.getValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_FLOORS, 0));

        // Get list House from CSV
        ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);
        // Add house to list
        houseList.add((House) house);
        // Write to CSV
        FuncWriteAndReadFileCSV.writeHouseToFileCsv(houseList);

        System.out.println("--- Add House: " + house.getServiceName() + " Successfully");
        backMainMenu();
    }

    //Add New Room
    private static void addNewRoom() {
        Services room = new Room();
        // Enter common property
        room = addNewService(room);

        // Set free services
        ((Room) room).setFreeService(FuncValidation.getValidFreeServices(ENTER_FREE_SERVICES, INVALID_FREE_SERVICES));

        // Get list Room from CSV
        ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);
        // Add Room to list
        roomList.add((Room) room);
        // Write to CSV
        FuncWriteAndReadFileCSV.writeRoomToFileCsv(roomList);

        System.out.println("--- Add Room: " + room.getServiceName() + " Successfully");
        backMainMenu();
    }

    //Add New Service
    private static Services addNewService(Services services) {
        // Set Service ID
        services.setId(FuncValidation.getValidIdService(services, ENTER_SERVICE_ID, INVALID_SERVICE_ID));

        //Set Service Name
        services.setServiceName(FuncValidation.getValidName(ENTER_SERVICE_NAME, INVALID_SERVICE_NAME));

        //Set Area Used
        services.setAreaUsed(FuncValidation.getValidNumberDouble(ENTER_AREA_USED, INVALID_DOUBLE_NUMBER, 30.0));

        //Set Rental Costs.
        services.setRentalCosts(FuncValidation.getValidNumberDouble(ENTER_RENTAL_COSTS, INVALID_RENTAL_COSTS, 0.0));

        //Set Max Number Of People
        services.setMaxNumberOfPeople(FuncValidation.getValidNumberInteger(ENTER_MAX_NUMBER_OF_PEOPLE, INVALID_MAX_PEOPLE, 0, 20));

        //Set rent type
        services.setRentType(FuncValidation.getValidName(ENTER_RENT_TYPE, INVALID_RENT_TYPE));

        return services;
    }
    public static void showServices() {
        displayMenuShowServices();
        processMenuShowServices();
    }
    public static void processMenuShowServices() {
        switch (ScannerUtils.scanner.nextLine()) {
            case "1":
                showVilla();
                break;
            case "2":
                showHouse();
                break;
            case "3":
                showRoom();
                break;
            case "4":
                showAllNameVilla();
                break;
            case "5":
                showAllNameHouse();
                break;
            case "6":
                showAllNameRoom();
                break;
            case "7":
                processMain();
                System.out.println("\n---------------------------------------------");
                break;
            case "8":
                System.exit(0);
                break;
            default:
                System.out.println("--- Nhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }
    private static void showVilla() {
        ArrayList<Villa> villaList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.VILLA);
        displayList(villaList);
        backMainMenu();
    }
    // Method Show List House
    private static void showHouse() {
        ArrayList<House> houseList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.HOUSE);
        displayList(houseList);
        backMainMenu();
    }
    private static void showRoom() {
        ArrayList<Room> roomList = FuncGeneric.getListFromCSV(FuncGeneric.EntityType.ROOM);
        displayList(roomList);
        backMainMenu();
    }
    private static void showAllNameVilla() {
        showAllNameNotDuplicate(FuncGeneric.EntityType.VILLA);
    }

    private static void showAllNameHouse() {
        showAllNameNotDuplicate(FuncGeneric.EntityType.HOUSE);
    }

    private static void showAllNameRoom() {
        showAllNameNotDuplicate(FuncGeneric.EntityType.ROOM);
    }

}
