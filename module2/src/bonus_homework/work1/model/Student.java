package bonus_homework.work1.model;

public class Student extends Person {
    private double score;
    private String nameClass;

    public Student() {
    }



    @Override
    public String toString() {
//        return "Student{" +
//                " ID = " + getId() +
//                " ,Name =" + getName() +
//                " ,Date of Birth = " + getDateOfBirth() +
//                " Sex = " + getSex() +
//                " ,score = " + score +
//                " ,nameClass = '" + nameClass +
//                "} ";
      return String.format("%s,%s,%s,%s,%s,%s", this.getId(), this.getName(), this.getDateOfBirth(),this.getSex(),nameClass,score);
    }

    public Student(double score, String nameClass) {
        this.score = score;
        this.nameClass = nameClass;
    }



    public Student(int id, String name, String dateOfBirth, String sex, String nameClass, double score) {
        super(id, name, dateOfBirth, sex);
        this.score = score;
        this.nameClass = nameClass;
    }
}