package case_study.service.utils;

import case_study.model.person.Customer;
import case_study.model.person.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String src) {
        FileReader file = null;
        String line = "";
        List<String> strings = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            file = new FileReader(src);
            bufferedReader = new BufferedReader(file);
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

   public static List<Employee> readFileEmployee(String Path) {
        List<String> employeeList = readFile(Path);
        List<Employee> employees = new ArrayList<>();
        if (employeeList.size() == 0) {
            System.out.println("File null");
            return null;
        } else {
            String[] propertiesOfEmployee;
            Employee employee;
            for (int i = 0; i < employeeList.size(); i++) {
                propertiesOfEmployee = employeeList.get(i).split(",");
                if (propertiesOfEmployee.length == 10) {
                    employee = new Employee(propertiesOfEmployee[0], propertiesOfEmployee[1], propertiesOfEmployee[2], Long.parseLong(propertiesOfEmployee[3]), propertiesOfEmployee[4], propertiesOfEmployee[5], propertiesOfEmployee[6], propertiesOfEmployee[7], propertiesOfEmployee[8], Double.parseDouble(propertiesOfEmployee[9]));
                    employees.add(employee);
                }
            }
            return employees;
        }
    }
    public static List<Customer> readFileCustomer(String Path) {
        List<String> customerList = readFile(Path);
        List<Customer> customers = new LinkedList<>();
        if (customerList.size() == 0) {
            System.out.println("Dữ liệu trong file không có");
            return null;
        } else {
            String[] propertiesOfCustomer;
            Customer customer;
            for (int i = 0; i < customerList.size(); i++) {
                propertiesOfCustomer = customerList.get(i).split(",");
                if (propertiesOfCustomer.length == 9) {
                    customer = new Customer(propertiesOfCustomer[0], propertiesOfCustomer[1], propertiesOfCustomer[2], Long.parseLong(propertiesOfCustomer[3]), propertiesOfCustomer[4], propertiesOfCustomer[5], propertiesOfCustomer[6], propertiesOfCustomer[7], propertiesOfCustomer[8]);
                    customers.add(customer);
                }
            }
            return customers;
        }
    }
}
