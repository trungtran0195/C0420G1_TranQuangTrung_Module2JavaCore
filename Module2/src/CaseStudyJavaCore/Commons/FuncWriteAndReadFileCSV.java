package CaseStudyJavaCore.Commons;


import CaseStudyJavaCore.Models.Customer;
import CaseStudyJavaCore.Models.House;
import CaseStudyJavaCore.Models.Room;
import CaseStudyJavaCore.Models.Villa;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class FuncWriteAndReadFileCSV {
    // the delimiter to use for separating entries
    public static final char DEFAULT_SEPARATOR = ',';
    // the character to use for quoted elements
    public static final char DEFAULT_QUOTE = '"';

    // the line number to skip for start reading
    public static final int NUM_OF_LINE_SKIP = 1;

    // path file Villa
    public static final String pathVilla = "src/Data/Villa.csv";

    // path file Room.csv
    public static final String pathRoom = "src/Data/Room.csv";

    // path file House
    public static final String pathHouse = "src/Data/House.csv";

    // path file House
    public static final String pathCustomer = "src/Data/Customer.csv";

    // path file Booking
    public static final String pathBooking = "src/Data/Booking.csv";

    // path file Employee
    public static final String pathEmployee = "src/Data/Employee.csv";

    // header Villa.csv
    public static String[] headerRecordVilla = new String[]{"id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};

    // header Room.csv
    public static String[] headerRecordRoom = new String[]{"id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType", "freeService"};

    // header House.csv
    public static String[] headerRecordHouse = new String[]{"id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType", "roomStandard", "convenientDescription", "numberOfFloors"};

    // header House.csv
    public static String[] headerRecordCustomer = new String[]{"fullName", "birthday", "gender", "idCard", "phone", "email", "customerType", "address"};

    // header Employee.csv
    public static String[] headerRecordEmployee = new String[]{"id", "fullName", "age", "address"};

    //header Booking.csv
    public static String[] headerRecordBooking = new String[]{"fullName", "birthday", "gender", "idCard", "phone", "email", "customerType", "address",
            "id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType"};

    //function write Villa to File CSV
    public static void writeVillaToFileCsv(ArrayList<Villa> arrayList) {
        try (Writer writer = new FileWriter(pathVilla);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : arrayList) {
                csvWriter.writeNext(new String[]
                        {villa.getId(), villa.getServiceName(), String.valueOf(villa.getAreaUsed()), String.valueOf(villa.getRentalCosts()), String.valueOf(villa.getMaxNumberOfPeople()),
                                villa.getRentType(), villa.getRoomStandard(), villa.getConvenientDescription(), String.valueOf(villa.getAreaPool()), String.valueOf(villa.getNumberOfFloors())});
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //function write House to File CSV
    public static void writeHouseToFileCsv(ArrayList<House> arrayList) {
        try (Writer writer = new FileWriter(pathHouse);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {
            //add Header of File
            csvWriter.writeNext(headerRecordHouse);
            for (House house : arrayList) {
                csvWriter.writeNext(new String[]
                        {house.getId(), house.getServiceName(), String.valueOf(house.getAreaUsed()), String.valueOf(house.getRentalCosts()), String.valueOf(house.getMaxNumberOfPeople()),
                                house.getRentType(), house.getRoomStandard(), house.getConvenientDescription(), String.valueOf(house.getNumberOfFloors())});
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //function write Room to File CSV
    public static void writeRoomToFileCsv(ArrayList<Room> arrayList) {
        try (Writer writer = new FileWriter(pathRoom);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {
            //add Header of File
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : arrayList) {
                csvWriter.writeNext(new String[]
                        {room.getId(), room.getServiceName(), String.valueOf(room.getAreaUsed()), String.valueOf(room.getRentalCosts()), String.valueOf(room.getMaxNumberOfPeople()),
                                room.getRentType(), room.getFreeService()});
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //function write Customer to File CSV
    public static void writeCustomerToFileCsv(ArrayList<Customer> arrayList) {
        try (Writer writer = new FileWriter(pathCustomer);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            //add Header of File
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getFullName(), customer.getBirthday() , customer.getGender(), String.valueOf(customer.getIdCard()),
                                customer.getPhone(), customer.getEmail(), customer.getCustomerType(), customer.getAddress()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //write Booking to File CSV
    public static void writeBookingToFileCsv(ArrayList<Customer> arrayList) {
        try (Writer writer = new FileWriter(pathBooking);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            //add Header of File
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getFullName(), customer.getBirthday(), customer.getGender(), customer.getIdCard(),
                                customer.getPhone(), customer.getEmail(), customer.getCustomerType(), customer.getAddress(),
                                customer.getServices().getId(), customer.getServices().getServiceName(), String.valueOf(customer.getServices().getAreaUsed()), String.valueOf(customer.getServices().getRentalCosts()),
                                String.valueOf(customer.getServices().getMaxNumberOfPeople()),
                                customer.getServices().getRentType()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //get list Booking from CSV
    public static ArrayList<Customer> getBookingFromCSV() {
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        try (Reader reader = new FileReader(pathBooking);
             CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] line;
            csvReader.skip(1);
            while ((line = csvReader.readNext()) != null) {
                Customer customer = new Customer();
                Villa villa = new Villa();
                int pos = 0;
                customer.setFullName(line[pos++]);
                customer.setBirthday(line[pos++]);
                customer.setGender(line[pos++]);
                customer.setIdCard(line[pos++]);
                customer.setPhone(line[pos++]);
                customer.setEmail(line[pos++]);
                customer.setAddress(line[pos++]);
                customer.setCustomerType(line[pos++]);

                villa.setId(line[pos++]);
                villa.setServiceName(line[pos++]);
                villa.setAreaUsed(Double.parseDouble(line[pos++]));
                villa.setRentalCosts(Double.parseDouble(line[pos++]));
                villa.setMaxNumberOfPeople(Integer.parseInt(line[pos++]));
                villa.setRentType(line[pos++]);
                customer.setServices(villa);
                listCustomer.add(customer);
            }
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
        return listCustomer;
    }

    public static TreeSet<String> getAllNameServiceFromCSV(String path) {
        BufferedReader br = null;
        TreeSet<String> result = new TreeSet();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                if (getNameServicesFromFile(line).equals("serviceName")) {
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
//        result.descendingSet();
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
}
