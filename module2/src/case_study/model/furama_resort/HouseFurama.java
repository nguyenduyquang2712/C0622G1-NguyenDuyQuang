package case_study.model.furama_resort;

public class HouseFurama extends Facility {
    private String roomStandard;
    private int numberOfFloors;

    public HouseFurama(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public HouseFurama(String nameService, double usableArea, double rentalCost, int maxNumberOfPeople, String rentalType, String roomStandard, int numberOfFloors) {
        super(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType);
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
        return  super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}