package case_study.controller;

import case_study.service.ICustomerService;
import case_study.service.IEmployeeService;
import case_study.service.IFacilityService;
import case_study.service.impl.CustomerService;
import case_study.service.impl.EmployeeService;
import case_study.service.impl.FacilityService;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    private static final Scanner scan = new Scanner(System.in);

    private static final IFacilityService furamaResort = new FacilityService();
    private static final IEmployeeService employee = new EmployeeService();

    private static final ICustomerService customer = new CustomerService();
    public void menuUser() throws IOException {
        while (true) {
            System.out.println("---------------Welcome to Furama resort----------");
            System.out.println("---------------Please select the services below----------");
            System.out.println(" 1. Employee Management" +
                    "\n 2. Customer Management" +
                    "\n 3. Facility Management" +
                    "\n 4. Facility Management" +
                    "\n 5. Booking Management" +
                    "\n 6. Promotion Management" +
                    "\n 7. Exit");
            int choice;
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            switch (choice) {
                case 1:
                    System.out.println("---------------Please select the services below----------");
                    System.out.println(" 1.1 Display list employees" +
                            "\n 1.2 Add new employee" +
                            "\n 1.3 Edit employee" +
                            "\n 1.4 Return main menu" +
                            "\n 1.5 Exit");
                    int chooseEmployees;
                    try {
                        chooseEmployees = Integer.parseInt(scan.nextLine());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    switch (chooseEmployees) {
                        case 1:
                            employee.displayEmployee();
                            break;
                        case 2:
                            employee.addEmployee();
                            break;
                        case 3:
                            employee.editEmployee();
                            break;
                        case 4:
                            menuUser();
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 5");
                    }
                    break;
                case 2:
                    System.out.println("---------------Please select the services below----------");
                    System.out.println(" 2.1 Display list customers" +
                            "\n 2.2 Add new customer" +
                            "\n 2.3 Edit customer" +
                            "\n 2.4 Return main menu" +
                            "\n 2.5 Exit");
                    int chooseCustomer;
                    try {
                        chooseCustomer = Integer.parseInt(scan.nextLine());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    switch (chooseCustomer) {
                        case 1:
                            break;
                        case 2:
                            customer.addCustomer();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 5");
                    }
                    break;
                case 3:
                    System.out.println("---------------Please select the services below----------");
                    System.out.println(" 3.1 Display list facility" +
                            "\n 3.2 Add new facility" +
                            "\n 3.3 Display list facility maintenance" +
                            "\n 3.4 Return main menu" +
                            "\n 3.5 Exit");
                    int chooseFacility;
                    try {
                        chooseFacility = Integer.parseInt(scan.nextLine());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    switch (chooseFacility) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 5");
                    }
                    break;
                case 4:
                    System.out.println("---------------Please select the services below----------");
                    System.out.println(" 4.1 Add new booking" +
                            "\n 4.2 Display list booking" +
                            "\n 4.3 Create new contracts" +
                            "\n 4.4 Display list contracts" +
                            "\n 4.5 Edit contracts" +
                            "\n 4.6 Return main menu");
                    int chooseBooking = 0;
                    try {
                        chooseBooking = Integer.parseInt(scan.nextLine());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    switch (chooseBooking) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 7");
                    }
                    break;
                case 5:
                    System.out.println("---------------Please select the services below----------");
                    System.out.println(" 5.1 Display list customer use service" +
                            "\n 5.2 Display list customers get voucher" +
                            "\n 5.3 Return main menu" +
                            "\n 5.4 Exit");
                    int choosePromotion = 0;
                    try {
                        choosePromotion = Integer.parseInt(scan.nextLine());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    switch (choosePromotion) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 7");
                    }
                    break;
                case 6:
                    menuUser();
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 6");
                case 7:
                    return;
            }
        }
    }
}