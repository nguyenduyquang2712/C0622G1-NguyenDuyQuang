package case_study.model.contract;

public class Contract {
    private String numberContract;
    private String bookingId;
    private double advanceDepositAmount;
    private double totalPaymentAmount;
    private String customerID;

    public Contract() {
    }

    public Contract(String numberContract, String bookingId, double advanceDepositAmount, double totalPaymentAmount, String customerID) {
        this.numberContract = numberContract;
        this.bookingId = bookingId;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customerID = customerID;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(double advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getcustomerID() {
        return customerID;
    }

    public void setcustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
//        return "Contract{" +
//                "numberContract=" + numberContract +
//                ", bookingId='" + bookingId + '\'' +
//                ", advanceDepositAmount=" + advanceDepositAmount +
//                ", totalPaymentAmount=" + totalPaymentAmount +
//                ", customerID='" + customerID + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s",numberContract,bookingId,advanceDepositAmount,totalPaymentAmount,customerID);
    }
}