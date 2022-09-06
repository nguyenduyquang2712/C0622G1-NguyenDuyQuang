package case_study.model.person;

import java.util.Objects;

public class Customer extends Person {
    private String customerId;
    private String customerType;
    private String addressCustomer;

    public Customer(String customerId, String customerType, String addressCustomer) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.addressCustomer = addressCustomer;
    }

    public Customer(String nameCustomer, String dayOfBirth, String gender, long identifyCard, String numberOfPhone, String email, String customerId, String customerType, String addressCustomer) {
        super(nameCustomer, dayOfBirth, gender, identifyCard, numberOfPhone, email);
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
//        return super.toString()+
//                "Customer{" +
//                "customerId='" + customerId + '\'' +
//                ", customerType='" + customerType + '\'' +
//                ", addressCustomer='" + addressCustomer + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",this.getNameEmployee(),this.getDayOfBirth(),this.getGender(),this.getidentifyCard(),this.getNumberOfPhone(),this.getEmail(),customerId,customerType,addressCustomer);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer){
            Customer another = (Customer) obj;
            if(this.customerId.equals(another.customerId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}