package exam_module2.model;

public class Employee extends Person implements Comparable<Employee>{
    private double wage;
    private String roomWork;
    private String workPosition;

    public Employee() {
    }

    public Employee(String id, String name, String birthDay, String address, String phoneNumber, double wage, String roomWork, String workPosition) {
        super(id, name, birthDay, address, phoneNumber);
        this.wage = wage;
        this.roomWork = roomWork;
        this.workPosition = workPosition;
    }

    public Employee(double wage, String roomWork, String workPosition) {
        this.wage = wage;
        this.roomWork = roomWork;
        this.workPosition = workPosition;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getRoomWork() {
        return roomWork;
    }

    public void setRoomWork(String roomWork) {
        this.roomWork = roomWork;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getBirthDay(),this.getAddress(),this.getPhoneNumber(),wage,roomWork,workPosition);
    }

    @Override
    public String toString() {
        return super.toString()+
                "Employee{" +
                "wage=" + wage +
                ", roomWork='" + roomWork + '\'' +
                ", workPosition='" + workPosition + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}
