package case_study.service.impl.validate;

import case_study.model.person.Customer;
import case_study.service.utils.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerIDChecking {
    private static final String SRC_DATA_CUSTOMER_FILE_CSV = "src\\case_study\\data\\Customer.csv";
    public static boolean checkingCustomerID(String iD){
        List<Customer> customerList = new ArrayList<>();
        customerList = ReadFile.readFileCustomer(SRC_DATA_CUSTOMER_FILE_CSV);
        if(customerList==null){
            return false;
        }
        for(Customer customer:customerList){
            if(customer.getCustomerId().equals(iD)){
                return true;
            }
        }
        return false;
    }
}
