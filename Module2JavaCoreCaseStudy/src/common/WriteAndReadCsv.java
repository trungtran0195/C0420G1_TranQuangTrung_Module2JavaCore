package common;

import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class WriteAndReadCsv {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    protected static final String pathVilla = "src/data/Villa.csv";
    protected static final String pathRoom = "src/data/Room.csv";
    protected static final String pathHouse = "src/data/House.csv";
    private static final String pathCustomer = "src/data/Customer.csv";
    private static final String pathBooking = "src/data/Booking.csv";
    private static final String pathEmployee = "src/data/Employee.csv";

    //csv file header
    private static final String FILE_HEADER_VILLA = "id,name,area,rentCost,maxPeople,rentType,roomStandard,convenient,poolArea,floors";
    private static final String FILE_HEADER_HOUSE = "id,name,area,rentCost,maxPeople,rentType,roomStandard,convenient,floors";
    private static final String FILE_HEADER_ROOM = "id,name,area,rentCost,maxPeople,rentType,freeService";
    private static final String FILE_HEADER_CUSTOMER= "name,birthday,gender,idCard,phone,email,customerType,address";
    private static final String FILE_HEADER_BOOKING = "fullName,birthday,gender,idCard,phone,email,customerType,address,id,serviceName,areaUsed,rentalCosts,maxNumberOfPeople,rentType";
    private static final String FILE_HEADER_EMPLOYEE = "id,fullName,age,address";

    public static void writeVillaToFileCsv(ArrayList<Villa> listVilla,boolean append) {
        checkFileExists(pathVilla);

        try {
            FileWriter fileWriter = new FileWriter(pathVilla,append);
            StringBuffer buffer = new StringBuffer();
            List<String> check =Files.readAllLines(Paths.get(pathVilla));
            if (check.size()==0){
                fileWriter.append(FILE_HEADER_VILLA);
            }
            for (Villa villa: listVilla) {
                buffer.append(NEW_LINE_SEPARATOR);
                buffer.append(villa.getId());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getServiceName());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getAreaUsed());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getRentalCosts());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getMaxNumberOfPeople());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getRentType());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getRoomStandard());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getConvenientDescription());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getAreaPool());
                buffer.append(COMMA_DELIMITER);
                buffer.append(villa.getNumberOfFloors());
                System.out.println("--- Add Villa: " + villa.getServiceName() + " Successfully");
                fileWriter.append(buffer.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeHouseToFileCsv(ArrayList<House> listHouse, boolean append) {
        checkFileExists(pathHouse);

        try {
            FileWriter fileWriter = new FileWriter(pathHouse, append);
            StringBuffer buffer = new StringBuffer();
            List<String> check =Files.readAllLines(Paths.get(pathHouse));
            if (check.size()==0){
                fileWriter.append(FILE_HEADER_HOUSE);
            }
            for (House house: listHouse) {
                buffer.append(NEW_LINE_SEPARATOR);
                buffer.append(house.getId()).append(COMMA_DELIMITER);
                buffer.append(house.getServiceName()).append(COMMA_DELIMITER);
                buffer.append(house.getAreaUsed()).append(COMMA_DELIMITER);
                buffer.append(house.getRentalCosts()).append(COMMA_DELIMITER);
                buffer.append(house.getMaxNumberOfPeople()).append(COMMA_DELIMITER);
                buffer.append(house.getRentType()).append(COMMA_DELIMITER);
                buffer.append(house.getRoomStandard()).append(COMMA_DELIMITER);
                buffer.append(house.getConvenientDescription()).append(COMMA_DELIMITER);
                buffer.append(house.getNumberOfFloors());
                System.out.println("--- Add House: " + house.getServiceName() + " Successfully");
                fileWriter.append(buffer.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRoomToFileCsv(ArrayList<Room> listRoom, boolean append) {
        checkFileExists(pathRoom);

        try {
            FileWriter fileWriter = new FileWriter(pathRoom, append);
            StringBuffer buffer = new StringBuffer();
            List<String> check =Files.readAllLines(Paths.get(pathRoom));
            if (check.size()==0){
                fileWriter.append(FILE_HEADER_ROOM);
            }
            for (Room room:listRoom) {
                buffer.append(NEW_LINE_SEPARATOR);
                buffer.append(room.getId()).append(COMMA_DELIMITER);
                buffer.append(room.getServiceName()).append(COMMA_DELIMITER);
                buffer.append(room.getAreaUsed()).append(COMMA_DELIMITER);
                buffer.append(room.getRentalCosts()).append(COMMA_DELIMITER);
                buffer.append(room.getMaxNumberOfPeople()).append(COMMA_DELIMITER);
                buffer.append(room.getRentType()).append(COMMA_DELIMITER);
                buffer.append(room.getFreeService());
                System.out.println("--- Add Room: " + room.getServiceName() + " Successfully");
                fileWriter.append(buffer.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Villa> getVillaListFromCSV() {
        BufferedReader bufferedReader = null;
        ArrayList<Villa> listVilla = new ArrayList<>();
        try {
            String line;
            FileReader fileReader = new FileReader(pathVilla);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] arrVilla = line.split(",");
                if (arrVilla[0].equals("id")){
                    continue;
                }
                Villa villa = new Villa();
                villa.setId(arrVilla[0]);
                villa.setServiceName(arrVilla[1]);
                villa.setAreaUsed(Double.parseDouble(arrVilla[2]));
                villa.setRentalCosts(Double.parseDouble(arrVilla[3]));
                villa.setMaxNumberOfPeople(Integer.parseInt(arrVilla[4]));
                villa.setRentType(arrVilla[5]);
                villa.setRoomStandard(arrVilla[6]);
                villa.setConvenientDescription(arrVilla[7]);
                villa.setAreaPool(Double.parseDouble(arrVilla[8]));
                villa.setNumberOfFloors(Integer.parseInt(arrVilla[9]));
                listVilla.add(villa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
        return listVilla;
    }

    public static ArrayList<House> getHouseListFromCSV() {
        BufferedReader bufferedReader = null;
        ArrayList<House> listHouse = new ArrayList<>();
        try {
            String line;
            FileReader fileReader = new FileReader(pathHouse);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String arrHouse[] = line.split(",");
                if (arrHouse[0].equals("id")){
                    continue;
                }
                House house = new House();
                house.setId(arrHouse[0]);
                house.setServiceName(arrHouse[1]);
                house.setAreaUsed(Double.parseDouble(arrHouse[2]));
                house.setRentalCosts(Double.parseDouble(arrHouse[3]));
                house.setMaxNumberOfPeople(Integer.parseInt(arrHouse[4]));
                house.setRentType(arrHouse[5]);
                house.setRoomStandard(arrHouse[6]);
                house.setConvenientDescription(arrHouse[7]);
                house.setNumberOfFloors(Integer.parseInt(arrHouse[8]));
                listHouse.add(house);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
        return listHouse;
    }

    public static ArrayList<Room> getRoomListFromCSV() {
        BufferedReader bufferedReader = null;
        ArrayList<Room> listRoom = new ArrayList<>();
        try {
            String line;
            FileReader fileReader = new FileReader(pathRoom);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] arrRoom =line.split(",");
                if (arrRoom[0].equals("id")){
                    continue;
                }
                Room room = new Room();
                room.setId(arrRoom[0]);
                room.setServiceName(arrRoom[1]);
                room.setAreaUsed(Double.parseDouble(arrRoom[2]));
                room.setRentalCosts(Double.parseDouble(arrRoom[3]));
                room.setMaxNumberOfPeople(Integer.parseInt(arrRoom[4]));
                room.setRentType(arrRoom[5]);
                room.setFreeService(arrRoom[6]);
                listRoom.add(room);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
        return listRoom;
    }

    public static void writeCustomerToFileCsv(Customer customer, boolean append) {
        checkFileExists(pathCustomer);

        try {
            FileWriter fileWriter = new FileWriter(pathCustomer, append);
            StringBuffer buffer = new StringBuffer();
            List<String> check =Files.readAllLines(Paths.get(pathCustomer));
            if (check.size()==0){
                fileWriter.append(FILE_HEADER_CUSTOMER);
            }
            buffer.append(NEW_LINE_SEPARATOR);
            buffer.append(customer.getFullName()).append(COMMA_DELIMITER);
            buffer.append(customer.getBirthday()).append(COMMA_DELIMITER);
            buffer.append(customer.getGender()).append(COMMA_DELIMITER);
            buffer.append(customer.getIdCard()).append(COMMA_DELIMITER);
            buffer.append(customer.getPhone()).append(COMMA_DELIMITER);
            buffer.append(customer.getEmail()).append(COMMA_DELIMITER);
            buffer.append(customer.getCustomerType()).append(COMMA_DELIMITER);
            buffer.append(customer.getAddress());
            fileWriter.append(buffer.toString());
            System.out.println("---add customer:" + customer.getFullName() + "----");
            fileWriter.flush();
            fileWriter.close();

        }catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static ArrayList<Customer> getCustomerListFromCSV() {
        BufferedReader bufferedReader = null;
        ArrayList<Customer> listCustomer = new ArrayList<>();
        try {
            String line;
            FileReader fileReader = new FileReader(pathCustomer);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrCustomer = line.split(",");
                if (arrCustomer[0].equals("name")) {
                    continue;
                }
                Customer customer = new Customer();
                customer.setFullName(arrCustomer[0]);
                customer.setBirthday(arrCustomer[1]);
                customer.setGender(arrCustomer[2]);
                customer.setIdCard(arrCustomer[3]);
                customer.setPhone(arrCustomer[4]);
                customer.setEmail(arrCustomer[5]);
                customer.setCustomerType(arrCustomer[6]);
                customer.setAddress(arrCustomer[7]);
                listCustomer.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
        return listCustomer;
    }

    public static ArrayList<Employee> getEmployeeListFromCSV() {
        BufferedReader bufferedReader = null;
        ArrayList<Employee> listEmployee = new ArrayList<>();
        try {
            String line;
            FileReader fileReader = new FileReader(pathEmployee);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrEmployee = line.split(",");
                if (arrEmployee[0].equals("id")) {
                    continue;
                }
                Employee employee = new Employee();
                employee.setId(arrEmployee[0]);
                employee.setFullName(arrEmployee[1]);
                employee.setAge(Integer.parseInt(arrEmployee[2]));
                employee.setAddress(arrEmployee[3]);
                listEmployee.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
        return listEmployee;
    }

    public static void writeBookingToFileCsv(ArrayList<Customer> listBooking, boolean append) {
        checkFileExists(pathBooking);

        try {
            FileWriter fileWriter = new FileWriter(pathBooking, append);
            StringBuffer buffer = new StringBuffer();
            List<String> check =Files.readAllLines(Paths.get(pathBooking));
            if (check.size()==0){
                fileWriter.append(FILE_HEADER_BOOKING);
            }
            for (Customer booking:listBooking) {
                buffer.append(NEW_LINE_SEPARATOR);
                buffer.append(booking.getFullName()).append(COMMA_DELIMITER);
                buffer.append(booking.getBirthday()).append(COMMA_DELIMITER);
                buffer.append(booking.getGender()).append(COMMA_DELIMITER);
                buffer.append(booking.getIdCard()).append(COMMA_DELIMITER);
                buffer.append(booking.getPhone()).append(COMMA_DELIMITER);
                buffer.append(booking.getEmail()).append(COMMA_DELIMITER);
                buffer.append(booking.getCustomerType()).append(COMMA_DELIMITER);
                buffer.append(booking.getAddress()).append(COMMA_DELIMITER);
                buffer.append(booking.getServices().getId()).append(COMMA_DELIMITER);
                buffer.append(booking.getServices().getServiceName()).append(COMMA_DELIMITER);
                buffer.append(booking.getServices().getAreaUsed()).append(COMMA_DELIMITER);
                buffer.append(booking.getServices().getRentalCosts()).append(COMMA_DELIMITER);
                buffer.append(booking.getServices().getMaxNumberOfPeople()).append(COMMA_DELIMITER);
                buffer.append(booking.getServices().getRentType());
                System.out.println("Customer: "+booking.getFullName()+ "check in to :"+booking.getServices().getServiceName()+ " Successfully");
                fileWriter.append(buffer.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<String> getAllNameServiceFromCSV(String path) {
        BufferedReader br = null;
        TreeSet<String> result = new TreeSet();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                if (getNameServicesFromFile(line).equals("name")) {
                    continue;
                }
                result.add(getNameServicesFromFile(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        result.descendingSet();
        return result;
    }

    public static String getNameServicesFromFile(String csvLine) {
        String name = "";
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            name = splitData[1];
        }
        return name;
    }

    public static void checkFileExists( String filePath) {
        if (!Files.exists(Paths.get(filePath))) {
            try {
                Files.createFile(Paths.get(filePath));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}
