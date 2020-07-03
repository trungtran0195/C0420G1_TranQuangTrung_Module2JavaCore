package controllers;

import model.House;
import model.Room;
import model.Services;
import model.Villa;

public class TestShowInfo {
    public static void main(String[] args) {
        Services villa = new Villa("V1", "Villa 1", 150.5, 950000, 10, "Hour", "Vip", "Has 2 bathroom", 80, 6);
        villa.showInfo();
        System.out.println("\n---------------------------------------------");
        Services house = new House("H1", "house 1", 50, 250000, 5, "Hour", "Normal", "Has 1 bathroom", 3);
        house.showInfo();
        System.out.println("\n---------------------------------------------");
        Services room = new Room("R1", "Room 1", 20, 50000, 1, "Hour", "Water");
        room.showInfo();
    }
}
