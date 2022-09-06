package case_study.service.utils;

import case_study.model.person.Customer;
import case_study.model.person.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WriteFile {
    public static void writeFile(String src, boolean append, List<String> list) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(src, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i<list.size(); i++) {
                bufferedWriter.write(list.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
    public static String convertEmployeeToString(Employee employee) {
        return employee.getNameEmployee()+","+employee.getDayOfBirth()+","+employee.getGender()+","+employee.getidentifyCard()+","+employee.getNumberOfPhone()+","+employee.getEmail()+","+employee.getEmployeeId()+","+employee.getLevel()+","+employee.getworkPosition()+","+employee.getWage();
    }
    public static List<String> convertListEmployeeToListString(List<Employee> employees) {
        List<String> strings = new ArrayList<>();
        for(Employee employee: employees) {
            strings.add(convertEmployeeToString(employee));
        }
        return strings;
    }
    public static String convertCustomerToString(Customer customer) {
        return customer.getNameEmployee()+","+customer.getDayOfBirth()+","+customer.getGender()+","+customer.getidentifyCard()+","+customer.getNumberOfPhone()+","+customer.getEmail()+","+customer.getCustomerId()+","+customer.getCustomerType()+","+customer.getAddressCustomer();
    }
    public static List<String> convertListCustomerToListString(List<Customer> customers) {
        List<String> strings = new LinkedList<>();
        for(Customer customer: customers) {
            strings.add(convertCustomerToString(customer));
        }
        return strings;
    }
}
