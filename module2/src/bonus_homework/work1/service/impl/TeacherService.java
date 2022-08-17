package bonus_homework.work1.service.impl;

import bonus_homework.work1.model.Student;
import bonus_homework.work1.model.Teacher;
import bonus_homework.work1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "quang", "12/12/12", "nam", "tutor"));
        teachers.add(new Teacher(2, "hai", "12/12/12", "nam", "coach"));
    }

    @Override
    public void showAllTeacher() {
        for (Teacher teacher : teachers
        ) {
            System.out.println(teacher);
        }
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giảng viên thành công");
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Không tìm thấy đối tượng cần xóa");
        } else {
            System.out.println("Bạn có thực sự muốn xóa " + teacher.getId() + " không?");
            System.out.println("1 . Có");
            System.out.println("2 . Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Xóa thành công");
            }
        }

    }

    @Override
    public void searchTeacher() {
        while (true) {
            System.out.println("1. Tìm kiếm giảng viên theo ID");
            System.out.println("2. Tìm kiếm giảng viên theo tên");
            System.out.println("3. Exit");
            System.out.println("Mời bạn nhập tùy chọn 1->3");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    findInforTeacherById();
                    break;
                case 2:
                    findInforTeacherByName();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lại lựa chọn");
                    break;
            }
        }
    }

    private void findInforTeacherByName() {
        System.out.println("Nhập ID giảng viên cần tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                System.out.println(teacher);
                return;
            }
        }
        System.out.println(" Không tìm thấy id");
    }

    private void findInforTeacherById() {
        System.out.println("Nhập name giảng viên cần tìm kiếm");
        String nameStudent = scanner.nextLine();
        boolean check = false;
        for(Teacher teacher:teachers){
            if (teacher.getName().contains(nameStudent)){
                System.out.println(teacher);
                check = true;
            }
        }
        if(!check) {
            System.out.println("Ko tìm thấy tên cần tìm");
        }
    }



    private Teacher findTeacher() {
        System.out.print("Mời bạn nhập vào id cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < teachers.size(); i++) {
//            if (teachers.get(i).getId() == id) {
//                return teachers.get(i);
//            }
//        }
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    private Teacher infoTeacher() {
        System.out.print("Mời bạn nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (true) {
            boolean check = true;
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
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
        System.out.print("Mời bạn nhập trình độ chuyên môn: ");
        String qualification = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, dateOfBirth, sex, qualification);
        return teacher;
    }
}