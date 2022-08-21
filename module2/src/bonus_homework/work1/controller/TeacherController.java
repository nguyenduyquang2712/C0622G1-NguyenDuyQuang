package bonus_homework.work1.controller;

import bonus_homework.work1.service.ITeacherService;
import bonus_homework.work1.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static Scanner scanner = new Scanner(System.in);
    private ITeacherService teacherService = new TeacherService();

    public void menuManagementTeacher() {
        while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("Chào mừng bạn đến với CODEGYM");
            System.out.println("1. Hiển thị danh sách giảng viên (theo alpha b");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Xóa giảng viên");
            System.out.println("4. Tìm kiếm thông tin Giảng viên");
            System.out.println("5. Quay lại trang chính");
            try {
                System.out.print("Mời bạn nhập chức năng 1->5: ");
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2) {
                    case 1:
                        teacherService.showAllTeacher();
                        break;
                    case 2:
                        teacherService.addTeacher();
                        break;
                    case 3:
                        teacherService.removeTeacher();
                        break;
                    case 4:
                        teacherService.searchTeacher();
                    case 5:
                        return;
                    default:
                        System.out.println("Lựa chọn bạn nhập không đúng!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Không đúng định dạng số, mời nhập lại số");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
