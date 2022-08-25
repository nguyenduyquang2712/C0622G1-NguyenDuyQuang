package case_study.model.contract;

public class Contract {
    private long numberContract;
    private String bookingId;
    private long advanceDepositAmount;
    private long totalPaymentAmount;
    private String contractId;

    public Contract() {
    }

    public Contract(long numberContract, String bookingId, long advanceDepositAmount, long totalPaymentAmount, String contractId) {
        this.numberContract = numberContract;
        this.bookingId = bookingId;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.contractId = contractId;
    }

    public long getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(long numberContract) {
        this.numberContract = numberContract;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public long getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(long advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public long getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(long totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract=" + numberContract +
                ", bookingId='" + bookingId + '\'' +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", contractId='" + contractId + '\'' +
                '}';
    }
}