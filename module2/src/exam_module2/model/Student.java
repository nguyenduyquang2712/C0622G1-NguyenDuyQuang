package exam_module2.model;

public class Student extends Person implements Comparable<Student> {
    private double score;
    private String nameClass;
    private String dayRegister;

    public Student() {
    }

    public Student(String id, String name, String birthDay, String address, String phoneNumber, double score, String nameClass, String dayRegister) {
        super(id, name, birthDay, address, phoneNumber);
        this.score = score;
        this.nameClass = nameClass;
        this.dayRegister = dayRegister;
    }

    public Student(double score, String nameClass, String dayRegister) {
        this.score = score;
        this.nameClass = nameClass;
        this.dayRegister = dayRegister;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getDayRegister() {
        return dayRegister;
    }

    public void setDayRegister(String dayRegister) {
        this.dayRegister = dayRegister;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getBirthDay(),this.getAddress(),this.getPhoneNumber(),score,nameClass,dayRegister);
    }

    @Override
    public String toString() {
        return super.toString()+
                "Student{" +
                "score=" + score +
                ", nameClass='" + nameClass + '\'' +
                ", dayRegister='" + dayRegister + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
