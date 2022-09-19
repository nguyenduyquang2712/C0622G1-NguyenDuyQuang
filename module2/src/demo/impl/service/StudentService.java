package demo.impl.service;

import bonus_homework.work1.utils.WriteFileUtil;
import demo.impl.IStudentService;
import demo.impl.ultils.ReadFile;
import demo.model.Student;
import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static String SRC_STUDENT_FILE = "src\\demo\\impl\\data\\Student.csv";
    private static List<Student> students = new ArrayList<>();
    @Override
    public void displayListStudent() {
        students = readFileInfo(SRC_STUDENT_FILE);
        if(students.size()==0){
            System.out.println("No data");
            return;
        }
        for(Student student:students){
            System.out.println(student);
        }

    }

    @Override
    public void addStudent() {
        students = readFileInfo(SRC_STUDENT_FILE);
        Student student = this.addInforStudent();
        students.add(student);
        System.out.println("Completed add student to the list");
        writeStudentFile(SRC_STUDENT_FILE,students);
    }

    @Override
    public void sortStudentList() {
        students = readFileInfo(SRC_STUDENT_FILE);
        while(true) {
            try {
                System.out.println("Chose option you want to sort list student\n" +
                        "1. Sort by id\n" +
                        "2. Sort by name\n" +
                        "3. Return menu");
                int choice = Integer.parseInt(scanner.nextLine());
                boolean check = false;
                switch (choice) {
                    case 1:
                        Collections.sort(students, new Comparator<Student>() {
                            @Override
                            public int compare(Student o1, Student o2) {
                                return o1.getId().compareTo(o2.getId());
                            }
                        });
                        check=true;
                        break;
                    case 2:
                        Collections.sort(students, new Comparator<Student>() {
                            @Override
                            public int compare(Student o1, Student o2) {
                                return o1.getName().compareTo(o2.getName());
                            }
                        });
                        check=true;
                        break;
                    case 3: return;
                    default:
                        System.out.println("Please reenter right choice");
                }
               if(check) break;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
        writeStudentFile(SRC_STUDENT_FILE,students);
    }

    @Override
    public void searchStudent() {
        while (true) {
            try {
                System.out.println("choose option you want search\n"+
                        "1. By Id\n"+
                        "2. By Name\n"+
                        "3. Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                boolean check = false;
                switch (choice){
                    case 1:
                        searchStudentById();
                        break;
                    case 2:
                        searchStudentByName();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Please enter the right choice");
                }
                if(check){
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void editStudent() {
        students = readFileInfo(SRC_STUDENT_FILE);
        System.out.println("Enter the id student you want edit ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getId().equals(id)){
                students.set(i,addInforStudent());
                writeStudentFile(SRC_STUDENT_FILE,students);
                return;
            }
        }
        }

    @Override
    public void deleteStudent() {
        students  =readFileInfo(SRC_STUDENT_FILE);
        System.out.println("Enter the id student you want to delete");
        String id = scanner.nextLine();
        for(Student student:students){
            if(student.getId().equals(id)){
                System.out.println("You want to detele student have id is: "+id+"\n"+
                        "1.Yes\n"+
                        "2.No");
                int choice = Integer.parseInt(scanner.nextLine());
                if(choice==1){
                    System.out.println("no delete anything");
                    return;
                }
                if(choice==2) {
                    students.remove(student);
                    System.out.println("completed delete student");
                    writeStudentFile(SRC_STUDENT_FILE, students);
                    return;
                }

            }
        }
        System.out.println("No have data to delete");
    }


    private void searchStudentByName() {
        students = readFileInfo(SRC_STUDENT_FILE);
        System.out.println("Enter name of student you want to search");
        String name = scanner.nextLine();
        for(Student student: students){
            if(student.getName().contains(name)){
                System.out.println(student);
            }
        }
    }

    private void searchStudentById() {
        students=readFileInfo(SRC_STUDENT_FILE);
        System.out.println("Enter id want to seach ");
        String id = scanner.nextLine();
        for(Student student:students){
            if(student.getId().equals(id)){
                System.out.println(student);
            }
        }
    }

    private Student addInforStudent() {
        String name;
        name = scanner.nextLine();
        String id;
        id = scanner.nextLine();
        String birthDay;
        birthDay = scanner.nextLine();
        double score;
        score = Double.parseDouble(scanner.nextLine());
        String className;
        className = scanner.nextLine();
        Student student = new Student(name,id,birthDay,score,className);
        return student;
    }
    public static void writeStudentFile(String path, List<Student> students){
        String data = "";
        for (Student student : students) {
            data += student.getInfo();
            data += "\n";
        }

        WriteFileUtil.writeFile(path, data);
    }
    public static List<Student> readFileInfo(String path){
        List<String> strings = ReadFile.readFile(path);
        List<Student> students = new ArrayList<>();
        String[] info;
        for(String line:strings){
            if(!line.equals("")) {
                info = line.split(",");
                if (info.length == 5) {
                    students.add(new Student(info[0], info[1], info[2], Double.parseDouble(info[3]), info[4]));
                }
            }
        }
        return students;
    }
}
