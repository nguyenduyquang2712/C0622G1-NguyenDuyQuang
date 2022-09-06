package case_study.service.impl;

import case_study.model.booking.Booking;
import case_study.model.furama_resort.Facility;
import case_study.model.person.Customer;
import case_study.service.IBookingService;
import case_study.service.impl.exception.InfoBookingException;
import case_study.service.impl.validate.CustomerIDChecking;
import case_study.service.impl.validate.ServiceIDChecking;
import case_study.service.impl.validate.Validdate;
import case_study.service.utils.ReadFile;
import case_study.service.utils.WriteFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

public class BookingService implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static Set<Booking> bookingSet = new TreeSet<>();
    private static Set<Booking> bookingSetOfContract = new TreeSet<>();
    private FacilityService facilityService = new FacilityService();
    private CustomerService customerService = new CustomerService();
    private static final String SRC_DATA_BOOKING_FILE_CSV = "src\\case_study\\data\\Booking.csv";
    private static final String SRC_DATA_BOOKINFOFCONTRACT_FILE_CSV = "src\\case_study\\data\\BookingforContract.csv";


    @Override
    public void addBooking() throws IOException {
        List<Customer> customerList = ReadFile.readFileCustomer("src\\case_study\\data\\Customer.csv");
        Map<Facility, Integer> facilityIntegerMap = facilityService.readFacilityFile("src\\case_study\\data\\Facility.csv");
        if (customerList == null || facilityIntegerMap == null) {
            System.out.println("No data for booking, not have customer or dont have facility service working");
            return;
        }
        System.out.println("List Customer ");
        customerService.displayCustomers();
        System.out.println();
        System.out.println("List Facility");
        facilityService.displayListFacility();
        Booking booking = this.inforBooking();
        bookingSet.add(booking);
        if(booking.getServiceID().contains("SVVL") || booking.getServiceID().contains("SVHO")){
            bookingSetOfContract.add(booking);
        }
        System.out.println("Completed add booking");
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility facility : facilitySet) {
            if (booking.getServiceID().equals(facility.getServiceID())) {
                facilityIntegerMap.put(facility, facilityIntegerMap.get(facility) + 1);
                facilityService.writeFacilityFile("src\\case_study\\data\\Facility.csv", facilityIntegerMap);
            }
        }

        writeFileBooking(SRC_DATA_BOOKING_FILE_CSV, bookingSet);
        writeFileBooking(SRC_DATA_BOOKINFOFCONTRACT_FILE_CSV,bookingSetOfContract);


    }

    @Override
    public void displayListBooking() {

        bookingSet = readFileBooking(SRC_DATA_BOOKING_FILE_CSV);
        for (Booking booking : bookingSet) {
            System.out.println(booking);
        }
    }


    private Booking inforBooking() {
        bookingSet = readFileBooking(SRC_DATA_BOOKING_FILE_CSV);
        String bookingID;
        while (true) {
            try {
                System.out.println("Enter booking ID (input number XXX)");
                bookingID = scanner.nextLine();
                if (!bookingID.matches("\\d{3}")) {
                    throw new InfoBookingException("Not valid information booking");
                }
                bookingID = "BK" + bookingID;
                if (bookingSet != null) {
                    for (Booking booking : bookingSet) {
                        if (booking.getBookingId().equals(bookingID)) {
                            throw new InfoBookingException("Not valid information booking");
                        }
                    }
                }
                break;
            } catch (InfoBookingException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String customerID;
        while (true) {
            try {
                System.out.println("Enter Customer ID");
                customerID = scanner.nextLine();
                if (!CustomerIDChecking.checkingCustomerID(customerID)) {
                    throw new InfoBookingException("Not valid information booking");
                }
                break;
            } catch (InfoBookingException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String nameService;
        while (true) {
            try {
                System.out.println("Enter Name Service");
                nameService = scanner.nextLine();
                if (!nameService.equals("VillaFurama") && !nameService.equals("HouseFurama") && !nameService.equals("RoomFurama")) {
                    throw new InfoBookingException("Not valid information booking");
                }
                break;
            } catch (InfoBookingException e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceID;
        while (true) {
            try {
                System.out.println("Enter service Id");
                serviceID = scanner.nextLine();
                if (!ServiceIDChecking.checkingServiceID(serviceID)) {
                    throw new InfoBookingException("Not valid information booking");
                }
                if(nameService.contains("Villa")){
                    if(!serviceID.contains("SVVL")){
                        throw new InfoBookingException("Not valid information booking");
                    }
                }else if(nameService.contains("House")){
                    if(!serviceID.contains("SVHO")){
                        throw new InfoBookingException("Not valid information booking");
                    }
                }else{
                    if(!serviceID.contains("SVRO")){
                        throw new InfoBookingException("Not valid information booking");
                    }
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InfoBookingException e) {
                System.out.println(e.getMessage());
            }
        }
        String dayStart;
        while (true) {
            try {
                System.out.println("Enter day start booking");
                dayStart = scanner.nextLine();
                if (!Validdate.checkDate(dayStart)) {
                    throw new InfoBookingException("Not valid information booking, or facility is booked in that time");
                }
                if (bookingSet != null) {
                    for (Booking booking : bookingSet) {
                        if (booking.getServiceID().equals(serviceID)) {
                            if (Validdate.convertDay(dayStart).isAfter(Validdate.convertDay(booking.getDayStart())) && Validdate.convertDay(dayStart).isBefore(Validdate.convertDay(booking.getDayEnd()))) {
                                throw new InfoBookingException("Not valid information booking, or facility is booked in that time");
                            }
                            if (Validdate.convertDay(dayStart).isEqual(Validdate.convertDay(booking.getDayStart())) || Validdate.convertDay(dayStart).isEqual(Validdate.convertDay(booking.getDayEnd()))) {
                                throw new InfoBookingException("Not valid information booking, or facility is booked in that time");
                            }
                        }
                    }
                }
                break;
            } catch (InfoBookingException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String dayEnd;
        LocalDate dateStart = LocalDate.parse(dayStart, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        while (true) {
            try {
                System.out.println("Enter the day end booking");
                dayEnd = scanner.nextLine();
                if (!Validdate.checkDate(dayEnd)) {
                    throw new InfoBookingException("Not valid information booking, or facility is booked in that time");
                }
                LocalDate dateEnd = LocalDate.parse(dayEnd, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
                if (dateEnd.isBefore(dateStart)) {
                    throw new InfoBookingException("Not valid information booking, or facility is booked in that time");
                }
                if (bookingSet != null) {
                    for (Booking booking : bookingSet) {
                        if (booking.getServiceID().equals(serviceID)) {
                            if (Validdate.convertDay(dayStart).isBefore(Validdate.convertDay(booking.getDayStart()))) {
                                if (Validdate.convertDay(dayEnd).isEqual(Validdate.convertDay(booking.getDayStart())) || Validdate.convertDay(dayEnd).isAfter(Validdate.convertDay(booking.getDayStart()))) {
                                    throw new InfoBookingException("Not valid information booking, or facility is booked in that time");
                                }
                            }
                        }
                    }
                }
                break;
            } catch (InfoBookingException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Booking booking = new Booking(bookingID, dayStart, dayEnd, customerID, nameService, serviceID);
        return booking;
    }

    public static Set<Booking> readFileBooking(String path) {
        List<String> strings = ReadFile.readFile(path);
        Set<Booking> bookingSet = new TreeSet<>();
//        if (strings.size() == 0) {
//            return null;
//        }
        String[] info;
        for (String line : strings) {
            if (!line.equals("")){
                info = line.split(",");
                bookingSet.add(new Booking(info[0], info[1], info[2], info[3], info[4], info[5]));
            }
        }
        return bookingSet;
    }

    public static void writeFileBooking(String path, Set<Booking> bookingSet) {
        String data = "";
        for (Booking booking : bookingSet) {
            data += booking.toString();
            data += "\n";
        }
        try {
            WriteFile.writeFile(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}