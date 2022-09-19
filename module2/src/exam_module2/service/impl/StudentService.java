package exam_module2.service.impl;

import bonus_homework.work1.utils.WriteFileUtil;
import demo.impl.ultils.ReadFile;
import exam_module2.model.Student;
import exam_module2.service.IStudentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static final String SRC_STUDENT_FILE = "src\\exam_module2\\data\\Student.csv";
    @Override
    public void addStudent() {
        Student student = this.inforStudent();
        students.add(student);
        System.out.println("Completed add student");
        writeStudentFile(SRC_STUDENT_FILE,students);
    }

    @Override
    public void displayListStudent() {
        students = readFileStudent(SRC_STUDENT_FILE);
        Collections.sort(students);
        for(Student student: students){
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        students = readFileStudent(SRC_STUDENT_FILE);
        System.out.println("Enter the id student you want to delete");
        String id = scanner.nextLine();
        for(Student student:students){
            if(student.getId().equals(id)){
                System.out.println("You want to detele student have id is: "+id+"\n"+
                        "1.Yes\n"+
                        "2.No");
                int choice = Integer.parseInt(scanner.nextLine());

                if(choice==1) {
                    students.remove(student);
                    System.out.println("completed delete student");
                    writeStudentFile(SRC_STUDENT_FILE, students);
                    return;
                }
                if(choice==2){
                    System.out.println("no delete anything");
                    return;
                }
            }
        }
        System.out.println("No have data to delete");
    }

    private Student inforStudent() {
        String idStudent;
        System.out.println("Enter id student");
        idStudent = scanner.nextLine();;
        String nameStudent;
        System.out.println("Enter name student");
        nameStudent = scanner.nextLine();
        String birthDay;
        System.out.println("Enter birth day student ");
        birthDay = scanner.nextLine();
        String address;
        System.out.println("Enter address student");
        address = scanner.nextLine();
        String phoneNumber;
        System.out.println("Enter phone number student");
        phoneNumber = scanner.nextLine();
        double score;
        System.out.println("Enter score student");
        score = Double.parseDouble(scanner.nextLine());
        String className;
        System.out.println("Enter class name student");
        className = scanner.nextLine();
        String dayRegister;
        System.out.println("Enter day register student");
        dayRegister = scanner.nextLine();
        return new Student(idStudent,nameStudent,birthDay,address,phoneNumber,score,className,dayRegister);
    }
    public static void writeStudentFile(String path, List<Student> students){
        String data = "";
        for (Student student : students) {
            data += student.getInfo();
            data += "\n";
        }

        WriteFileUtil.writeFile(path, data);
    }
    public static List<Student> readFileStudent(String path){
        List<String> strings = ReadFile.readFile(path);
        List<Student> students = new ArrayList<>();
        String[] info;
        for(String line:strings){
            if(!line.equals("")) {
                info = line.split(",");
                if (info.length == 8) {
                    students.add(new Student(info[0], info[1], info[2],info[3], info[4],Double.parseDouble(info[5]),info[6],info[7]));
                }
            }
        }
        return students;
    }
}
