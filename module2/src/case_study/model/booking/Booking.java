package case_study.model.booking;

public class Booking {
    private String bookingId;
    private int dayStart;
    private int dayEnd;
    private String customerBookingId;
    private String nameService;
    private String typeService;

    public Booking() {
    }

    public Booking(String bookingId, int dayStart, int dayEnd, String customerBookingId, String nameService, String typeService) {
        this.bookingId = bookingId;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerBookingId = customerBookingId;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getDayStart() {
        return dayStart;
    }

    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(int dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCustomerBookingId() {
        return customerBookingId;
    }

    public void setCustomerBookingId(String customerBookingId) {
        this.customerBookingId = customerBookingId;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", dayStart=" + dayStart +
                ", dayEnd=" + dayEnd +
                ", customerBookingId='" + customerBookingId + '\'' +
                ", nameService='" + nameService + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}