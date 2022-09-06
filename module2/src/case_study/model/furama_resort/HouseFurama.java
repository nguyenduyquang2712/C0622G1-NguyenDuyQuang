package case_study.model.furama_resort;

import java.util.Objects;

public class HouseFurama extends Facility {
    private String roomStandard;
    private int numberOfFloors;

    public HouseFurama(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public HouseFurama(String nameService, double usableArea, double rentalCost, int maxNumberOfPeople, String rentalType, String serviceCode, String roomStandard, int numberOfFloors) {
        super(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType, serviceCode);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
//        return  super.toString()+
//                "roomStandard='" + roomStandard + '\'' +
//                ", numberOfFloors=" + numberOfFloors +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getNameService(),getUsableArea(),getRentalCost(),getMaxNumberOfPeople(),getRentalType(), getServiceID(),getRoomStandard(),getNumberOfFloors());
    }

}