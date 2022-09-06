package case_study.service.impl;

import bonus_homework.work1.utils.NameException;
import case_study.model.person.Employee;
import case_study.service.IEmployeeService;
import case_study.service.impl.exception.BasicInforException;
import case_study.service.impl.exception.InformationException;
import case_study.service.impl.validate.*;
import case_study.service.utils.ReadFile;
import case_study.service.utils.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String SRC_DATA_EMPLOYEE_FILE_CSV = "src\\case_study\\data\\Employee.csv";
    private static List<Employee> employees = new ArrayList<>();

//    static {
//        employees.add(new Employee("Nguyen Van A", "12/12/1995", "male", 3535, "84-123456789", "email@gmail.com", "01", "Intermediate", "manager", 35353));
//    }

    @Override
    public void displayEmployee() {
        try {
            employees = ReadFile.readFileEmployee(SRC_DATA_EMPLOYEE_FILE_CSV);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.out.println("Not have data");
        }

    }

    @Override
    public void addEmployee() {
        Employee employee = this.inforEmployee();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);
        System.out.println("Completed add employee to the list");
        WriteFile.writeFile(SRC_DATA_EMPLOYEE_FILE_CSV, true, WriteFile.convertListEmployeeToListString(employeeList));
    }

    @Override
    public void editEmployee() {
            employees = ReadFile.readFileEmployee(SRC_DATA_EMPLOYEE_FILE_CSV);
            if(employees.size()==0){
                System.out.println("Not have data");
                return;
            }
            System.out.println("Enter employeeID want to edit");
            String employeeID = scanner.nextLine();
            for (int i = 0; i < employees.size(); i++) {

                if (employees.get(i).getEmployeeId().equals(employeeID)) {
                    while (true) {
                        System.out.println(employees.get(i));
                        System.out.println("Enter the information you want to edit");
                        System.out.println("1.Edit name of employee\n" +
                                "2.Edit day of birth employee\n" +
                                "3.Edit gender of employee\n" +
                                "4.Edit identify Card of employee\n" +
                                "5.Edit phone number of employee\n" +
                                "6.Edit mail of employee\n" +
                                "7.Edit ID of employeee\n" +
                                "8.Edit level of employee\n" +
                                "9.Edit work position of employee\n" +
                                "10.Edit wage of employee\n" +
                                "11.Edit all\n" +
                                "12.Exit");
                        WriteFile.writeFile(SRC_DATA_EMPLOYEE_FILE_CSV, false, WriteFile.convertListEmployeeToListString(employees));
                        int choiceInfor = Integer.parseInt(scanner.nextLine());
                        switch (choiceInfor) {
                            case 1:
                                employees.get(i).setNameEmployee(scanner.nextLine());
                                break;
                            case 2:
                                employees.get(i).setDayOfBirth(scanner.nextLine());
                                break;
                            case 3:
                                employees.get(i).setGender(scanner.nextLine());
                                break;
                            case 4:
                                employees.get(i).setidentifyCard(Long.parseLong(scanner.nextLine()));
                                break;
                            case 5:
                                employees.get(i).setNumberOfPhone(scanner.nextLine());
                                break;
                            case 6:
                                employees.get(i).setEmail(scanner.nextLine());
                            case 7:
                                employees.get(i).setEmployeeId(scanner.nextLine());
                                break;
                            case 8:
                                employees.get(i).setLevel(scanner.nextLine());
                                break;
                            case 9:
                                employees.get(i).setworklPosition(scanner.nextLine());
                                break;
                            case 10:
                                employees.get(i).setWage(Double.parseDouble(scanner.nextLine()));
                                break;
                            case 11:
                                employees.set(i, inforEmployee());
                                break;
                            case 12:
                                return;
                            default:
                                System.out.println("Not valid choice, please reenter the choice ");
                        }
                    }
                }
            }
            System.out.println("ID you enter not exists");
        }



    private Employee inforEmployee() {
        employees = ReadFile.readFileEmployee(SRC_DATA_EMPLOYEE_FILE_CSV);
        String nameEmployee;
        while (true) {
            try {
                System.out.println("Enter the name of employee:");
                nameEmployee = scanner.nextLine();
                nameEmployee = nameEmployee.trim();
                if (!ValidNamePerson.checkName(nameEmployee)) {
                    throw new NameException("not valid name, please reenter name of employee");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String dayOfBirth;
        while (true) {
            try {
                System.out.println("Enter the day of birth:");
                dayOfBirth = scanner.nextLine();
                if (!Validdate.checkDateofBirth(dayOfBirth)) {
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
                System.out.println("Enter gender of employee:");
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
                System.out.println("Enter the identify card of employee:");
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
                System.out.println("Enter the phone number of employee:");
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

                System.out.println("Enter the email of employee");
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
        String employeeID;
        while (true) {
            try {
                System.out.println("Enter the employee ID: ");
                employeeID = scanner.nextLine();
                if (!employeeID.matches("^\\d{4}$")) {
                    throw new InformationException("not valid information, please reenter ");
                }
                employeeID = "EP" + employeeID;
                boolean check = false;
                employees = ReadFile.readFileEmployee(SRC_DATA_EMPLOYEE_FILE_CSV);
                if (employees != null) {
                    for (Employee employee : employees) {
                        if (employee.getEmployeeId().equals(employeeID)) {
                            System.out.println("ID employee is duplicated, please reenter the employee ID");
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
        String levelEmployee = "";
        while (true) {
            boolean check = false;
            System.out.println("Enter level of employee in list below");
            System.out.println("1.Intermediate\n" +
                    "2.College+\n" +
                    "3.University\n" +
                    "4.Postgraduate");
            try {
                int choiceLevel = Integer.parseInt(scanner.nextLine());
                switch (choiceLevel) {
                    case 1:
                        levelEmployee = "Intermediate";
                        check = true;
                        break;
                    case 2:
                        levelEmployee = "College";
                        check = true;
                        break;
                    case 3:
                        levelEmployee = "University";
                        check = true;
                        break;
                    case 4:
                        levelEmployee = "Postgraduate";
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
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String workPosition = "";
        while (true) {
            boolean check = false;
            System.out.println("Please enter the work position of employee!");
            System.out.println("1.Receptionist\n" +
                    "2.Service\n" +
                    "3.Expert\n" +
                    "4.Monitoring\n" +
                    "5.Leader\n" +
                    "6.Manager");
            try {
                int choicePosition = Integer.parseInt(scanner.nextLine());
                switch (choicePosition) {
                    case 1:
                        workPosition = "Receptionist";
                        check = true;
                        break;
                    case 2:
                        workPosition = "Service";
                        check = true;
                        break;
                    case 3:
                        workPosition = "Expert";
                        check = true;
                        break;
                    case 4:
                        workPosition = "Monitoring";
                        check = true;
                        break;
                    case 5:
                        workPosition = "Leader";
                        check = true;
                        break;
                    case 6:
                        workPosition = "Manager";
                        check = true;
                        break;
                    default:
                        System.out.println("Not valid choice, please reenter the choice");
                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double wage;
        while (true) {
            try {
                System.out.println("Enter the wage of employee");
                wage = Double.parseDouble(scanner.nextLine());
                if (wage < 0) {
                    throw new InformationException("not valid information");
                }
                break;
            } catch (InformationException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Employee employee = new Employee(nameEmployee, dayOfBirth, gender, identifyCard, phoneNumber, email, employeeID, levelEmployee, workPosition, wage);
        return employee;
    }
}



