package case_study.model.booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Booking implements Comparable<Booking> {
    private String bookingId;
    private String dayStart;
    private String dayEnd;
    private String customerBookingId;
    private String nameService;
//    private String typeService;
    private String serviceID;

    public Booking() {
    }

    public Booking(String bookingId, String dayStart, String dayEnd, String customerBookingId, String nameService, String serviceID) {
        this.bookingId = bookingId;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerBookingId = customerBookingId;
        this.nameService = nameService;
//        this.typeService = typeService;
        this.serviceID = serviceID;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
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

//    public String getTypeService() {
//        return typeService;
//    }
//
//    public void setTypeService(String typeService) {
//        this.typeService = typeService;
//    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    @Override
    public String toString() {
//        return "Booking{" +
//                "bookingId='" + bookingId + '\'' +
//                ", dayStart=" + dayStart +
//                ", dayEnd=" + dayEnd +
//                ", customerBookingId='" + customerBookingId + '\'' +
//                ", nameService='" + nameService + '\'' +
//                ", typeService='" + typeService + '\'' +
//                ", serviceID='" + serviceID + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s",bookingId,dayStart,dayEnd,customerBookingId,nameService,serviceID);
    }

    @Override
    public int compareTo(Booking o) {
        LocalDate dayStartCheck = LocalDate.parse(this.dayStart, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        LocalDate dayStartCheck2 = LocalDate.parse(o.dayStart, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        LocalDate dayEndCheck = LocalDate.parse(this.dayEnd,DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        LocalDate dayEndCheck2 = LocalDate.parse(o.dayEnd,DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        if(!this.dayStart.equals(o.dayStart)){
            return dayStartCheck.compareTo(dayStartCheck2);
        }
        else if(!this.dayEnd.equals(o.dayEnd)) {
            return dayEndCheck.compareTo(dayEndCheck2);
        }else return this.bookingId.compareTo(o.bookingId);
    }
}