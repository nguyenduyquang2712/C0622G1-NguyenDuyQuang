package case_study.model.person;

public abstract class Person {
    private String name;
    private String dayOfBirth;
    private String gender;
    private long CMND;
    private long numberOfPhone;
    private String email;

    public Person() {
    }


    public String getNameEmployee() {
        return name;
    }

    public void setNameEmployee(String nameEmployee) {
        this.name = nameEmployee;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getCMND() {
        return CMND;
    }

    public void setCMND(long CMND) {
        this.CMND = CMND;
    }

    public long getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(long numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Person(String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email) {
        this.name = nameEmployee;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.CMND = CMND;
        this.numberOfPhone = numberOfPhone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", nameEmployee='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", CMND=" + CMND +
                ", numberOfPhone=" + numberOfPhone +
                ", email='" + email+
                '}';
    }
}