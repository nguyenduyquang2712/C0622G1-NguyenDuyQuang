package case_study.model.person;

public class Customer extends Person {
    private String customerId;
    private String customerType;
    private String addressCustomer;

    public Customer(String customerId, String customerType, String addressCustomer) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.addressCustomer = addressCustomer;
    }

    public Customer(String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email, String customerId, String customerType, String addressCustomer) {
        super(nameEmployee, dayOfBirth, gender, CMND, numberOfPhone, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.addressCustomer = addressCustomer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerType='" + customerType + '\'' +
                ", addressCustomer='" + addressCustomer + '\'' +
                '}';
    }
}