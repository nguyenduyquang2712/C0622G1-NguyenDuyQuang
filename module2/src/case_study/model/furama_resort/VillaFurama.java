package case_study.model.furama_resort;

public class VillaFurama extends Facility {
    private String roomStandard;
    private double swimmingOfArea;
    private int numberOfFloors;

    public VillaFurama(String roomStandard, double swimmingOfArea, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.swimmingOfArea = swimmingOfArea;
        this.numberOfFloors = numberOfFloors;
    }

    public VillaFurama(String nameService, double usableArea, double rentalCost, int maxNumberOfPeople, String rentalType, String roomStandard, double swimmingOfArea, int numberOfFloors) {
        super(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingOfArea = swimmingOfArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getSwimmingOfArea() {
        return swimmingOfArea;
    }

    public void setSwimmingOfArea(double swimmingOfArea) {
        this.swimmingOfArea = swimmingOfArea;
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
                ", swimmingOfArea=" + swimmingOfArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}