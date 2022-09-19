package demo.model;

public class Teacher extends Person {
    private String qualification;

    public Teacher() {
    }

    public Teacher(String qualification) {
        this.qualification = qualification;
    }

    public Teacher(String name, String id, String birthDay, String qualification) {
        super(name, id, birthDay);
        this.qualification = qualification;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s",this.getName(),this.getId(),this.getBirthDay(),this.qualification);
    }

    @Override
    public String toString() {
        return  super.toString()+
                "Teacher{" +
                "qualification='" + qualification + '\'' +
                '}';
    }
}
