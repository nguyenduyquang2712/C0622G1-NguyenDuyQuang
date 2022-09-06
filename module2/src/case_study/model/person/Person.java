package case_study.model.person;

public abstract class Person {
    private String name;
    private String dayOfBirth;
    private String gender;
    private long identifyCard;
    private String numberOfPhone;
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

    public long getidentifyCard() {
        return identifyCard;
    }

    public void setidentifyCard(long identifyCard) {
        this.identifyCard = identifyCard;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Person(String nameEmployee, String dayOfBirth, String gender, long identifyCard, String numberOfPhone, String email) {
        this.name = nameEmployee;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.identifyCard = identifyCard;
        this.numberOfPhone = numberOfPhone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", namePerson='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", identifyCard=" + identifyCard +
                ", numberOfPhone=" + numberOfPhone +
                ", email='" + email+
                '}';
    }
}