package bonus_homework.work1.controller;

import bonus_homework.work1.service.IStudentService;
import bonus_homework.work1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private IStudentService studentService = new StudentService();

    public void menuManagementStudent() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với CODEGYM");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Sửa thông tin học viên");
            System.out.println("5. Quay lại trang chính");
            System.out.print("Mời bạn nhập chức năng 1->5: ");
            int choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
                    studentService.showAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.removeStudent();
                    break;
                case 4:
                    studentService.changeInfoStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không đúng!");
            }

        }
    }
}
