package controllers;

import common.GeneralFunction;
import common.ScannerUtils;
import common.Validation;
import common.WriteAndReadCsv;
import model.House;
import model.Room;
import model.Services;
import model.Villa;

import java.util.ArrayList;

import static common.GeneralFunction.displayList;
import static common.GeneralFunction.showAllNameNotDuplicate;
import static common.Menu.displayMenuAddNewServices;
import static common.Menu.displayMenuShowServices;
import static controllers.MainController.backMainMenu;
import static controllers.MainController.processMain;

public class ServiceController {

    public static final String ENTER_SERVICE_ID = "Enter service ID: ";
    public static final String INVALID_SERVICE_ID = "Service ID is invalid. Service ID mus be format SVXX-YYYY, Y : 0-9, XX : case Villa is VL, case House is HO, case Room is RO . Please try again !!!";
    public static final String ENTER_SERVICE_NAME = "Enter service Name: ";
    public static final String INVALID_SERVICE_NAME = "Service name is invalid. Service name must be capitalized with first letters, the following characters is normal characters. Please try again !!!";
    public static final String ENTER_AREA_USED = "Enter Area Used: ";
    public static final String INVALID_AREA_USED = "Area Used is invalid (Area > 30, Area must be a Double). Please try again!!!";
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
    public static final String ENTER_CONVENIENT_DESCRIPTION = "Enter Convenient Description:";

    public static void addNewServices() {
        displayMenuAddNewServices();
        processMenuAddNewService();
    }

    public static void showService(){
        displayMenuShowServices();
        processMenuShowServices();
    }

    //Add service
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

    private static void addNewRoom() {
        ArrayList<Room> listRoom = new ArrayList<Room>();
        Services room = new Room();
        room = addNewService(room);

        ((Room) room).setFreeService(Validation.getValidFreeServices(ENTER_FREE_SERVICES,INVALID_FREE_SERVICES));

        listRoom.add((Room) room);
        WriteAndReadCsv.writeRoomToFileCsv(listRoom,true);


        backMainMenu();
    }

    private static void addNewHouse() {
        ArrayList<House> listHouse = new ArrayList<House>();
        Services house = new House();
        house = addNewService(house);

        ((House) house).setRoomStandard(Validation.getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        ((House) house).setConvenientDescription(Validation.getValidName(ENTER_CONVENIENT_DESCRIPTION,INVALID_SERVICE_NAME));

        ((House) house).setNumberOfFloors(Validation.getValidNumberInteger(ENTER_NUMBER_OF_FLOORS,INVALID_NUMBER_FLOORS,1));

        listHouse.add((House) house);
        WriteAndReadCsv.writeHouseToFileCsv(listHouse,true);


        backMainMenu();
    }

    private static void addNewVilla() {
        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        Services villa = new Villa();
        villa = addNewService(villa);

        ((Villa) villa).setRoomStandard(Validation.getValidName(ENTER_ROOM_STANDARD, INVALID_ROOM_STANDARD));

        ((Villa) villa).setAreaPool(Validation.getValidNumberDouble(ENTER_AREA_POOL, INVALID_AREA_POOL, 30.0));

        ((Villa) villa).setNumberOfFloors(Validation.getValidNumberInteger(ENTER_NUMBER_OF_FLOORS,INVALID_NUMBER_FLOORS,1));

        ((Villa) villa).setConvenientDescription(Validation.getValidName(ENTER_CONVENIENT_DESCRIPTION,INVALID_SERVICE_NAME));

        listVilla.add((Villa) villa);

        WriteAndReadCsv.writeVillaToFileCsv(listVilla,true);

        backMainMenu();
    }

    private static Services addNewService(Services services) {

        services.setId(Validation.getValidIdService(services,ENTER_SERVICE_ID,INVALID_SERVICE_ID));

        services.setServiceName(Validation.getValidName(ENTER_SERVICE_NAME,INVALID_SERVICE_NAME));

        services.setAreaUsed(Validation.getValidNumberDouble(ENTER_AREA_USED,INVALID_AREA_USED,1.0));

        services.setRentalCosts(Validation.getValidNumberDouble(ENTER_RENTAL_COSTS,INVALID_RENTAL_COSTS,1.0));

        services.setMaxNumberOfPeople(Validation.getValidNumberInteger(ENTER_MAX_NUMBER_OF_PEOPLE,INVALID_MAX_PEOPLE,1,20));

        services.setRentType(Validation.getValidName(ENTER_RENT_TYPE,INVALID_RENT_TYPE));

        return services;
    }

    //Show service
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

    private static void showAllNameVilla() {
        showAllNameNotDuplicate(GeneralFunction.EntityType.VILLA);
    }

    private static void showAllNameHouse() {
        showAllNameNotDuplicate(GeneralFunction.EntityType.HOUSE);
    }

    private static void showAllNameRoom() {
        showAllNameNotDuplicate(GeneralFunction.EntityType.ROOM);
    }

    private static void showRoom() {
        ArrayList<Room> roomList = WriteAndReadCsv.getRoomListFromCSV();
        displayList(roomList);
        backMainMenu();
    }

    private static void showHouse() {
        ArrayList<House> houseList = WriteAndReadCsv.getHouseListFromCSV();
        displayList(houseList);
        backMainMenu();
    }

    private static void showVilla() {
        ArrayList<Villa> villaList = WriteAndReadCsv.getVillaListFromCSV();
        displayList(villaList);
        backMainMenu();
    }

}
