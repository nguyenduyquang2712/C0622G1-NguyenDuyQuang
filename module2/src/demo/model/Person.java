package demo.model;

public abstract class Person {
    private String name;
    private String id;
    private String birthDay;

    public Person() {
    }

    public Person(String name, String id, String birthDay) {
        this.name = name;
        this.id = id;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
