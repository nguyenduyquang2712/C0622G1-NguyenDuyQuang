package case_study.model.furama_resort;

public class RoomFurama extends Facility {
    private String freeServiceIncluded;

    public RoomFurama(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public RoomFurama(String nameService, double usableArea, double rentalCost, int maxNumberOfPeople, String rentalType, String freeServiceIncluded) {
        super(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return super.toString() +
                "freeServiceIncluded='" + freeServiceIncluded + '\'' +
                '}';
    }
}