package bonus_homework.work1.controller;

import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);
    StudentController studentController = new StudentController();
    TeacherController teacherController = new TeacherController();

    public void menuManagement() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1. Quản lý giảng viên");
            System.out.println("2. Quản lý sinh viên");
            System.out.println("3. Exit");
            System.out.println("Mời bạn nhập chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teacherController.menuManagementTeacher();
            } else if (choice == 2) {
                studentController.menuManagementStudent();
            }else if (choice == 3) {
               return;
            }else {
                System.out.println("Bạn đã chọn sai, mời nhập lại chức năng");
            }
        }
    }
}
