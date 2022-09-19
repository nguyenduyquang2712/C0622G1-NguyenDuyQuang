package exam_module2.controller;

import exam_module2.service.IEmployeeService;
import exam_module2.service.IStudentService;
import exam_module2.service.impl.EmployeeService;
import exam_module2.service.impl.StudentService;

import java.util.Scanner;

public class CodeGymController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeService();
    private static IStudentService studentService = new StudentService();

    public void manageMenu() {
        while (true) {
            try {
                System.out.println("----------------------------------------------------");
                System.out.println("Menu manage CodeGym\n" +
                        "1. Add new person\n" +
                        "2. Remove person\n" +
                        "3. Display all list member of Codegym\n" +
                        "4. Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        while (true) {
                            System.out.println("Enter you choice: \n" +
                                    "1. add employee\n" +
                                    "2. add student\n" +
                                    "3. Return");
                            System.out.println("Enter you choice 1->3");
                            int choiceAdd = Integer.parseInt(scanner.nextLine());
                            boolean check = false;
                            switch (choiceAdd) {
                                case 1:
                                    employeeService.addEmployee();
                                    check = true;
                                    break;
                                case 2:
                                    studentService.addStudent();
                                    check = true;
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("You selection not suitable, please reenter");
                                    check = true;
                            }
                            if (!check) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.println("selec choice want to remove\n" +
                                    "1. Remove student\n" +
                                    "2. Remove employee\n" +
                                    "3. Return");
                            int choiceRemove = Integer.parseInt(scanner.nextLine());
                            boolean check = false;
                            switch (choiceRemove) {
                                case 1:
                                    studentService.removeStudent();
                                    check = true;
                                    break;
                                case 2:
                                    employeeService.removeEmployee();
                                    check = true;
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Your Selection is not suitable, please reenter your choice");
                                    check=true;
                            }
                            if (!check) {
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("List Student is: ");
                        employeeService.displayListEmplooyee();
                        System.out.println();
                        System.out.println("List Employee is: ");
                        studentService.displayListStudent();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Your selection is not suitable, please reenter your choice");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
