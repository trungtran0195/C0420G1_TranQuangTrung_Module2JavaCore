package common;

import model.Customer;
import model.House;
import model.Room;
import model.Villa;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;

import static common.WriteAndReadCsv.*;
import static controllers.MainController.backMainMenu;

public class GeneralFunction {
    public enum EntityType {
        VILLA,
        HOUSE,
        ROOM,
        CUSTOMER,
        EMPLOYEE
    }

    public static <E> void displayList(ArrayList<E> list) {
        int i = 1;
        System.out.println("--------list-------");
        for (E item : list) {
            System.out.println("STT :" +i);
            if (item instanceof Villa) {
                ((Villa) item).showInfo();
            } else if (item instanceof House) {
                ((House) item).showInfo();
            } else if (item instanceof Room) {
                ((Room) item).showInfo();
            } else if (item instanceof Customer) {
                ((Customer) item).showInfo();
            }
            i++;
            System.out.println("------------------");
        }
    }

    public static void showAllNameNotDuplicate(EntityType entityType) {
        String csvPath = "";
        switch (entityType) {
            case VILLA:
                csvPath = pathVilla;
                break;
            case HOUSE:
                csvPath = pathHouse;
                break;
            case ROOM:
                csvPath = pathRoom;
                break;
        }
        Path path = Paths.get(csvPath);
        if (!Files.exists(path)) {
            System.out.println("---file csv path not Exists!");
            backMainMenu();
        }
        TreeSet<String> treeSet = WriteAndReadCsv.getAllNameServiceFromCSV(csvPath);
        System.out.println("---- List Name Service Not Duplicate");
        for (String str : treeSet) {
            System.out.println(str);
            System.out.println("---------");
        }
        backMainMenu();
    }


}
