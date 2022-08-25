package case_study.model.person;

public class Employee extends Person {
    private String employeeId;
    private String level;
    private String location;
    private double wage;

    public Employee(String employeeId, String level, String location, double wage) {
        this.employeeId = employeeId;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email, String employeeId, String level, String location, double wage) {
        super(nameEmployee, dayOfBirth, gender, CMND, numberOfPhone, email);
        this.employeeId = employeeId;
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLevel() {
        switch (this.level) {
            case "1":
                return "Intermediate";
            case "2":
                return "College";
            case "3":
                return "University";
            case "4":
                return "After University";
        }
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        switch (this.location) {
            case "1":
                return "Receptionist";
            case "2":
                return "Service";
            case "3":
                return "Expert";
            case "4":
                return "Monitoring";
            case "5":
                return "Manage";
            case "6":
                return "Manager";
        }
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "employeeId='" + employeeId + '\'' +
                ", level='" + level + '\'' +
                ", location='" + location + '\'' +
                ", wage=" + wage +
                '}';
    }
}