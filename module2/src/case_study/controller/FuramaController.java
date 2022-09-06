package case_study.controller;

import case_study.service.*;
import case_study.service.impl.*;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    private static final Scanner scan = new Scanner(System.in);

    private static  IFacilityService furamaFacility = new FacilityService();
    private static IEmployeeService employee = new EmployeeService();
    private static  ICustomerService customer = new CustomerService();
    private static IBookingService bookingService = new BookingService();
    private static IContractService contractService = new ContractService();
    private static IPromotionService promotionService = new PromotionService();

    public void menuUser() throws IOException {
        while (true) {
            System.out.println("---------------Welcome to Furama resort----------");
            System.out.println("---------------Please select the services below----------");
            System.out.println("1. Employee Management\n" +
                    "2. Customer Management\n" +
                    "3. Facility Management\n" +
                    "4. Booking Management\n" +
                    "5. Promotion Management\n" +
                    "6. Exit");
            int choice;
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("1.1 Display list employees\n" +
                                "1.2 Add new employee\n" +
                                "1.3 Edit employee\n" +
                                "1.4 Return main menu\n" +
                                "1.5 Exit");
                        int choiceEmployees;
                        try {
                            choiceEmployees = Integer.parseInt(scan.nextLine());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        boolean check = false;
                        switch (choiceEmployees) {
                            case 1:
                                employee.displayEmployee();
                                check = true;
                                break;
                            case 2:
                                employee.addEmployee();
                                check=true;
                                break;
                            case 3:
                                employee.editEmployee();
                                check = true;
                                break;
                            case 4:
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable,please selections from 1 to 5");
                                check=true;
                        }
                        if(!check) break;
                    }
                   break;
                case 2:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("2.1 Display list customers\n" +
                                "2.2 Add new customer\n" +
                                "2.3 Edit customer\n" +
                                "2.4 Return main menu\n" +
                                "2.5 Exit");
                        int choiceCustomer;
                        try {
                            choiceCustomer = Integer.parseInt(scan.nextLine());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        boolean check = false;
                        switch (choiceCustomer) {
                            case 1:
                                customer.displayCustomers();
                                check = true;
                                break;
                            case 2:
                                customer.addCustomer();
                                check = true;
                                break;
                            case 3:
                                customer.editCustomer();
                                check = true;
                                break;
                            case 4:
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                check = true;
                                System.out.println("Your selection is not suitable, selections from 1 to 5");
                        }
                      if(!check) break;
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("3.1 Display list facility\n" +
                                "3.2 Add new facility\n" +
                                "3.3 Display list facility maintenance\n" +
                                "3.4 Maintain Facility\n"+
                                "3.5 Return main menu\n" +
                                "3.5 Exit");
                        int choiceFacility;
                        try {
                            choiceFacility = Integer.parseInt(scan.nextLine());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        boolean check = false;
                        switch (choiceFacility) {
                            case 1:
                                furamaFacility.displayListFacility();
                                check=true;
                                break;
                            case 2:
                                furamaFacility.addFacility();
                                check = true;
                                break;
                            case 3:
                                furamaFacility.displayFacilityMaintain();
                                check= true;
                                break;
                            case 4:
                                furamaFacility.maintainFacility();
                                check=true;
                                break;
                            case 5: break;
                            case 6:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable,please selections from 1 to 6");
                                check = true;
                        }
                        if(!check) break;
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("4.1 Add new booking\n" +
                                "4.2 Display list booking\n" +
                                "4.3 Create new contracts\n" +
                                "4.4 Display list contracts\n" +
                                "4.5 Edit contracts\n" +
                                "4.6 Return main menu\n"+
                                "4.7 Exit");
                        int choiceBooking;
                        try {
                            choiceBooking = Integer.parseInt(scan.nextLine());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        boolean check=false;
                        switch (choiceBooking) {
                            case 1:
                                bookingService.addBooking();
                                check=true;
                                break;
                            case 2:
                                bookingService.displayListBooking();
                                check=true;
                                break;
                            case 3:
                                contractService.createContract();
                                check=true;
                                break;
                            case 4:
                                contractService.displayListContract();
                                check=true;
                                break;
                            case 5:
                                contractService.editListContract();
                                check=true;
                                break;
                            case 6:
                                break;
                            case 7:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable, please selections from 1 to 7");
                        }
                        if(!check) break;
                    }
                    break;
                case 5:
                    while(true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println(" 5.1 Display list customer use service" +
                                "\n 5.2 Display list customers get voucher" +
                                "\n 5.3 Return main menu" +
                                "\n 5.4 Exit");
                        int choicePromotion = 0;
                        try {
                            choicePromotion = Integer.parseInt(scan.nextLine());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        boolean check=false;
                        switch (choicePromotion) {
                            case 1:
                                promotionService.displayCustomerOfYear();
                                check=true;
                                break;
                            case 2:
                                promotionService.displayVoucherOfCustomer();
                                check=true;
                                break;
                            case 3:
                                break;
                            case 4:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable, please selections from 1 to 4");
                                check=true;
                        }
                        if(!check) break;
                    }
                    break;
                case 6:
                   return;
                default:
                    System.out.println("Your selection is not suitable, please selections from 1 to 6");
            }
        }
    }
}