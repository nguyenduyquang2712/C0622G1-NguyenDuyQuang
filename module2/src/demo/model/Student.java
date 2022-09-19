package demo.model;

public class Student extends Person {
    private double score;
    private String className;

    public Student() {
    }

    public Student(double score, String className) {
        this.score = score;
        this.className = className;
    }

    public Student(String name, String id, String birthDay, double score, String className) {
        super(name, id, birthDay);
        this.score = score;
        this.className = className;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s",this.getName(),this.getId(),this.getBirthDay(),score,className);

    }

    @Override
    public String toString() {
        return super.toString()+
                "Student{" +
                "score=" + score +
                ", className='" + className + '\'' +
                '}';
    }
}
