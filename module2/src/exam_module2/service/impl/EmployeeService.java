package exam_module2.service.impl;

import bonus_homework.work1.utils.WriteFileUtil;
import demo.impl.ultils.ReadFile;
import exam_module2.model.Employee;
import exam_module2.model.Student;
import exam_module2.service.IEmployeeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    private static final String SRC_EMPLOYEE_FILE = "src\\exam_module2\\data\\Employee.csv";

    @Override
    public void addEmployee() {
        employees = readEmployee(SRC_EMPLOYEE_FILE);
        Employee employee = this.inforEmployee();
        employees.add(employee);
        System.out.println("Completed add employee");
        writeEmployeeFile(SRC_EMPLOYEE_FILE,employees);

    }

    private Employee inforEmployee() {
        String idEmployee;
        System.out.println("Enter id employee: ");
        idEmployee = scanner.nextLine();
        String nameEmployee;
        System.out.println("Enter name employee");;
        nameEmployee = scanner.nextLine();
        String birthDay;
        System.out.println("Enter birth day Employee");
        birthDay = scanner.nextLine();
        String address;
        System.out.println("Enter address Employee");
        address = scanner.nextLine();
        String phoneNumber;
        System.out.println("Enter phone number employee");
        phoneNumber = scanner.nextLine();
        double wage;
        System.out.println("Enter wage employee");
        wage = Double.parseDouble(scanner.nextLine());
        String workRoom;
        System.out.println("Enter work room employee");
        workRoom = scanner.nextLine();
        String workPosition;
        System.out.println("Enter work position employee");
        workPosition = scanner.nextLine();
        return new Employee(idEmployee,nameEmployee,birthDay,address,phoneNumber,wage,workRoom,workPosition);
    }

    public void displayListEmplooyee() {
            employees = readEmployee(SRC_EMPLOYEE_FILE);
             Collections.sort(employees);
            for(Employee employee:employees){
                System.out.println(employee);
            }
    }

    @Override
    public void removeEmployee() {
        employees = readEmployee(SRC_EMPLOYEE_FILE);
        System.out.println("Enter the id employee you want to delete");
        String id = scanner.nextLine();
        for(Employee employee:employees){
            if(employee.getId().equals(id)){
                System.out.println("You want to detele employee have id is: "+id+"\n"+
                        "1.Yes\n"+
                        "2.No");
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice==1) {
                    employees.remove(employee);
                    System.out.println("completed delete student");
                    writeEmployeeFile(SRC_EMPLOYEE_FILE, employees);
                    return;
                }
                if(choice==2){
                    System.out.println("no delete anything");
                    return;
                }
            }
        }
        System.out.println("No have data to delete");
    }

    public static void writeEmployeeFile(String path, List<Employee> employees){
        String data = "";
        for (Employee employee : employees) {
            data += employee.getInfo();
            data += "\n";
        }
        WriteFileUtil.writeFile(path, data);
    }
    public static List<Employee> readEmployee(String path){
        List<String> strings = ReadFile.readFile(path);
        List<Employee> employees = new ArrayList<>();
        String[] info;
        for(String line:strings){
            if(!line.equals("")) {
                info = line.split(",");
                if (info.length == 8) {
                    employees.add(new Employee(info[0], info[1], info[2],info[3], info[4],Double.parseDouble(info[5]),info[6],info[7]));
                }
            }
        }
        return employees;
    }
}
