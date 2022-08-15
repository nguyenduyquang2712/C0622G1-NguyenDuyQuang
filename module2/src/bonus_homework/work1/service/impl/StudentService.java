package bonus_homework.work1.service.impl;

import bonus_homework.work1.model.Student;
import bonus_homework.work1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "quang", "12/12/12", "nam", "c0622g1", 1));
        students.add(new Student(2, "hai", "12/12/12", "nam", "c0622g1", 7));
    }

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void showAllStudent() {
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có thực sự muốn xóa " + student.getId() + " không?");
            System.out.println("1 . Có");
            System.out.println("2 . Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Xóa thành công");
            }
        }
    }

    @Override
    public void changeInfoStudent() {
        Student student = this.findStudent();
        if(student == null){
            System.out.println("không tìm thấy đối tượng ");
        }else{
            for (int i = 0; i < students.size() ; i++) {
                if(students.get(i).getId() == student.getId()){
                    students.set(i,this.infoStudent());
                }
            }
        }
    }

    private Student findStudent() {
        System.out.print("Mời bạn nhập vào id cần xóa hoặc chỉnh sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < students.size(); i++) {
//            if (students.get(i).getId() == id) {
//                return students.get(i);
//            }
//        }
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private Student infoStudent() {
        System.out.print("Mời bạn nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (true) {
            boolean check = true;
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("ID bị trùng, mời bạn nhập lại id");
                    id = Integer.parseInt(scanner.nextLine());
                    check = false;
                    break;
                }
            }
            if (check) break;
        }
        System.out.print("Mời bạn nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Mời bạn nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.print("Mời bạn nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("Mời bạn nhập tên lớp: ");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name, dateOfBirth, sex, nameClass, point);
        return student;
    }
}