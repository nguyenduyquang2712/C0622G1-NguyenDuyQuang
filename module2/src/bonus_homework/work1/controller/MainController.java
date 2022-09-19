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
            try {
                System.out.println("Mời bạn nhập chức năng");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                    teacherController.menuManagementTeacher();
                    break;
                    case 2:
                    studentController.menuManagementStudent();
                    break;
                    case 3:
                    return;
                    default:
                    System.out.println("Bạn đã chọn sai số, mời nhập lại chức năng");
                    break;
            }
                }
            catch (NumberFormatException e){
                System.out.println("Không đúng định dạng số, mời nhập lại");
        }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
    }


}
}
