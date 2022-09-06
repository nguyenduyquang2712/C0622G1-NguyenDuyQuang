package case_study.service.impl;

import bonus_homework.work1.utils.NameException;
import case_study.model.person.Customer;
import case_study.service.ICustomerService;
import case_study.service.impl.exception.BasicInforException;
import case_study.service.impl.exception.InformationException;
import case_study.service.impl.validate.*;
import case_study.service.utils.ReadFile;
import case_study.service.utils.WriteFile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customers = new LinkedList<>();
    private static final String SRC_DATA_CUSTOMER_FILE_CSV = "src\\case_study\\data\\Customer.csv";

//    static {
//        customers.add(new Customer("quang", "12/12/1995", "male", 12412, "84-012345678", "q@gmail.com", "C02", "Gold", "DN"));
//    }

    @Override
    public void addCustomer() {
        Customer customer = this.inforCustomer();
        List<Customer> customerList = new LinkedList<>();
        customerList.add(customer);
        System.out.println("Completed add information customer to list of customers");
        WriteFile.writeFile(SRC_DATA_CUSTOMER_FILE_CSV, true, WriteFile.convertListCustomerToListString(customerList));
    }


    @Override
    public void displayCustomers() {
        try {
            customers = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            System.out.println("Not have Data");
        }
    }

    @Override
    public void editCustomer() {
        customers = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
        if(customers==null){
            System.out.println("Not have data");
            return;
        }
        System.out.println("Enter customerID want to edit");
        String customerID = scanner.nextLine();
        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getCustomerId().equals(customerID)) {
                while (true) {
                    System.out.println(customers.get(i));
                    System.out.println("Enter the information you want to edit");
                    System.out.println("1.Edit name of customer\n" +
                            "2.Edit day of birth customer\n" +
                            "3.Edit gender of customer\n" +
                            "4.Edit identify Card of customer\n" +
                            "5.Edit phone number of customer\n" +
                            "6.Edit email of customer\n" +
                            "7.Edit ID of customer\n" +
                            "8.Edit type of employee\n" +
                            "9.Edit address of employee\n" +
                            "10.Edit all\n" +
                            "11.Exit");
                    WriteFile.writeFile(SRC_DATA_CUSTOMER_FILE_CSV, false, WriteFile.convertListCustomerToListString(customers));
                    int choiceInfor = Integer.parseInt(scanner.nextLine());
                    switch (choiceInfor) {
                        case 1:
                            customers.get(i).setNameEmployee(scanner.nextLine());
                            break;
                        case 2:
                            customers.get(i).setDayOfBirth(scanner.nextLine());
                            break;
                        case 3:
                            customers.get(i).setGender(scanner.nextLine());
                            break;
                        case 4:
                            customers.get(i).setidentifyCard(Long.parseLong(scanner.nextLine()));
                            break;
                        case 5:
                            customers.get(i).setNumberOfPhone(scanner.nextLine());
                            break;
                        case 6:
                            customers.get(i).setEmail(scanner.nextLine());
                            break;
                        case 7:
                            customers.get(i).setCustomerId(scanner.nextLine());
                            break;
                        case 8:
                            customers.get(i).setCustomerType(scanner.nextLine());
                            break;
                        case 9:
                            customers.get(i).setAddressCustomer(scanner.nextLine());
                            break;
                        case 10:
                            customers.set(i, inforCustomer());
                            break;
                        case 11:
                            return;
                        default:
                            System.out.println("Not valid choice, please reenter the choice ");
                    }
                }
            }
        }
    }

    private Customer inforCustomer() {
        customers = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
        String nameCustomer;
        while (true) {
            try {
                System.out.println("Enter the name of customer:");
                nameCustomer = scanner.nextLine();
                if (!ValidNamePerson.checkName(nameCustomer)) {
                    throw new NameException("not valid name, please reenter name of customer");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String dayofBirth;
        while (true) {
            try {
                System.out.println("Enter the day of birth of Customer:");
                dayofBirth = scanner.nextLine();
                if (!Validdate.checkDateofBirth(dayofBirth)) {
                    throw new BasicInforException("Not valid information, please reenter ");
                }
                break;
            } catch (BasicInforException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String gender;
        while (true) {
            try {
                System.out.println("Enter gender of customer:");
                gender = scanner.nextLine();
                if (!gender.equals("male") && !gender.equals("female")) {
                    throw new InformationException("Not valid information, please reenter");
                }
                break;
            } catch (InformationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        long identifyCard;
        while (true) {
            try {
                System.out.println("Enter the identify card of customer:");
                String number = scanner.nextLine();
                if (!ValidIdentifyCard.checkIdentifyCard(number)) {
                    throw new BasicInforException("not valid information, please reenter ");
                }
                identifyCard = Long.parseLong(number);
                break;
            } catch (BasicInforException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String phoneNumber;
        while (true) {
            try {
                System.out.println("Enter the phone number of customer:");
                phoneNumber = scanner.nextLine();
                if (!ValidPhoneNumber.checkPhoneNumber(phoneNumber)) {
                    throw new BasicInforException("not valid information, please reenter ");
                }
                break;
            } catch (BasicInforException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String email;
        while (true) {
            try {

                System.out.println("Enter the email of customer");
                email = scanner.nextLine();
                if (!ValidEmail.checkEmail(email)) {
                    throw new BasicInforException("not valid information, please reenter ");
                }
                break;
            } catch (BasicInforException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String customerID;
        while (true) {
            try {
                System.out.println("Enter number of the customer ID (CM-XXXX):  ");
                customerID = scanner.nextLine();
                if (!customerID.matches("^\\d{4}$")) {
                    throw new InformationException("not valid information, please reenter ");
                }
                customerID = "CM" + customerID;
                boolean check = false;
                customers = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
                if (customers != null) {
                    for (Customer customer : customers) {
                        if (customer.getCustomerId().equals(customerID)) {
                            System.out.println("ID employee is duplicated, please reenter the customer ID");
                            check = true;
                            break;
                        }
                    }
                }
                if (!check) {
                    break;
                }
            } catch (InformationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String customerType = "";
        while (true) {
            boolean check = false;
            System.out.println("Enter customer Tye in list below");
            System.out.println("1.Diamond\n" +
                    "2.Platinium+\n" +
                    "3.Gold\n" +
                    "4.Silver\n" +
                    "5.Member");
            try {
                int choiceLevel = Integer.parseInt(scanner.nextLine());
                switch (choiceLevel) {
                    case 1:
                        customerType = "Diamond";
                        check = true;
                        break;
                    case 2:
                        customerType = "Platinium";
                        check = true;
                        break;
                    case 3:
                        customerType = "Gold";
                        check = true;
                        break;
                    case 4:
                        customerType = "Silver";
                        check = true;
                        break;
                    case 5:
                        customerType = "Member";
                        check = true;
                        break;
                    default:
                        System.out.println("Not valid choice, please reenter the choice");
                        break;
                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        String address;
        System.out.println("Enter address of customer");
        address = scanner.nextLine();
        Customer customer = new Customer(nameCustomer, dayofBirth, gender, identifyCard, phoneNumber, email, customerID, customerType, address);
        return customer;

    }
}

