package case_study.service.impl;

import case_study.model.booking.Booking;
import case_study.model.furama_resort.Facility;
import case_study.model.furama_resort.HouseFurama;
import case_study.model.furama_resort.RoomFurama;
import case_study.model.furama_resort.VillaFurama;
import case_study.model.person.Customer;
import case_study.service.IPromotionService;
import case_study.service.utils.ReadFile;
import case_study.service.utils.WriteFile;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PromotionService implements IPromotionService {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Customer, String> customerOfYearMap = new LinkedHashMap<>();
    private static Map<Customer, String> customerVoucher = new LinkedHashMap<>();
    private static final String SRC_DATA_BOOKING_FILE_CSV = "src\\case_study\\data\\Booking.csv";
    private static final String SRC_DATA_CUSTOMER_FILE_CSV = "src\\case_study\\data\\Customer.csv";
    private static final String SRC_DATA_PROMOTION_FILE_CSV = "src\\case_study\\data\\Promotion.csv";
    private static LocalDate dateNow = LocalDate.now();

    @Override
    public void displayCustomerOfYear() {
        this.prepartListCustomer();
        if(customerOfYearMap.size()==0){
            System.out.println("Not have data of customer in this year");
            return;
        }
        Set<Customer> customerSet = customerOfYearMap.keySet();
        for (Customer customer : customerSet) {
            System.out.println(customer);
        }
        customerOfYearMap.clear();
    }

    @Override
    public void displayVoucherOfCustomer() {
        this.prepareCustomerGainVoucher();
        if(customerVoucher.size()==0){
            System.out.println("No data");
            return;
        }
        Set<Customer> customerSetVoucher = customerVoucher.keySet();
        for (Customer customer : customerSetVoucher) {
            System.out.println(customer + "-> Gain " + customerVoucher.get(customer));
        }
    }

    private void prepartListCustomer() {
        Set<Booking> bookingSet = BookingService.readFileBooking(SRC_DATA_BOOKING_FILE_CSV);
        List<Customer> customerList = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
        System.out.println("Enter Year you want find customer booking service");
        String year = scanner.nextLine();
        for (Booking booking : bookingSet) {
            for (Customer customer : customerList) {
                if (booking.getCustomerBookingId().equals(customer.getCustomerId()) && booking.getDayStart().contains(year)) {
                    customerOfYearMap.put(customer, booking.getDayStart());
                }
            }
        }
    }

    private void prepareCustomerGainVoucher() {
        Set<Booking> bookingSetVoucher = BookingService.readFileBooking(SRC_DATA_BOOKING_FILE_CSV);
        List<Customer> customerListVoucher = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
        try {
            customerVoucher = readFacilityFile(SRC_DATA_PROMOTION_FILE_CSV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("You want show old Data or remake voucher\n" +
                    "1.Show old data\n" +
                    "2.Remake");
            System.out.println("Enter choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1: return;
                case 2:
                    customerVoucher.clear();
                    if(bookingSetVoucher.size()==0 || customerListVoucher.size()==0){
                        System.out.println("No data");
                        return;
                    }
                    Stack<String> voucher = new Stack<>();
                    Set<Customer> customers = new LinkedHashSet<>();
                    for (Booking booking : bookingSetVoucher) {
                        for (Customer customer : customerListVoucher) {
                            if (LocalDate.parse(booking.getDayStart(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).getMonth().equals(dateNow.getMonth())) {
                                if (booking.getCustomerBookingId().equals(customer.getCustomerId())) {
                                    customers.add(customer);
                                }
                            }
                        }
                    }
                    int amountdiscount50;
//                    System.out.println("Amount customer in month: " + customers.size());
                    while (true) {
                        try {
                            System.out.println("Enter amount voucher discount 50%");
                            amountdiscount50 = Integer.parseInt(scanner.nextLine());
                            break;
                        }
                        catch (NumberFormatException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    for (int i = 0; i < amountdiscount50; i++) {
                        voucher.push("Discount 50%");
                    }
                    int amountdiscount20;
                    while (true) {
                        try {
                            System.out.println("Enter amount voucher discount 20%");
                            amountdiscount20 = Integer.parseInt(scanner.nextLine());
                            break;
                        }
                        catch (NumberFormatException e){
                            System.out.println(e.getMessage());
                        }
                    }
                        for (int i = 0; i < amountdiscount20; i++) {
                            voucher.push("Discount 20%");
                    }
                    int amountdiscount10;
                        while (true) {
                            try {
                                System.out.println("Enter amount voucher discount 10%");
                                amountdiscount10 = Integer.parseInt(scanner.nextLine());
                                break;
                            }
                            catch (NumberFormatException e){
                                System.out.println(e.getMessage());
                            }
                        }
                        for (int i = 0; i < amountdiscount10; i++) {
                            voucher.push("Discount 10%");
                        }
                    Stack<Customer> customerStack = new Stack<>();
                    for(Customer customer:customers){
                       customerStack.add(customer);
                    }
                    if(voucher.size()<customerStack.size()){
                        for (int i = 0; i <customerStack.size()-voucher.size() ; i++) {
                            customerStack.pop();
                        }
                    }
                    for (int i = 0; i < customerStack.size() ; i++) {
                        if(voucher.isEmpty()){
                            break;
                        }
                        customerVoucher.put(customerStack.pop(), voucher.pop());
                        i--;
                    }


                    try {
                        writePromotionFile(SRC_DATA_PROMOTION_FILE_CSV,customerVoucher);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
            }
        }

    }
    public static Map<Customer, String> readFacilityFile(String path) throws IOException {
        List<String> strings = ReadFile.readFile(path);
        Map<Customer, String> customerList = new LinkedHashMap<>();
//        if(strings.size()==0){
//            return null;
//        }
        String[] info;
        for (String line : strings) {
            info = line.split(",");
                customerList.put(new Customer(info[0], info[1], info[2], Long.parseLong(info[3]), info[4], info[5], info[6], info[7],info[8]),info[9]);
        }
        return customerList;
    }

    public static void writePromotionFile(String path, Map<Customer, String> customerVoucher) throws IOException {
        String data = "";
        Set<Customer> customerSet = customerVoucher.keySet();
        for (Customer customer : customerSet) {
            data += customer.toString() + "," + customerVoucher.get(customer);
            data += "\n";
        }
        WriteFile.writeFile(path, data);
    }
}



