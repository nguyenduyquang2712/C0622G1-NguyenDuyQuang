package bonus_homework.work1.service.impl;

import bonus_homework.work1.model.Student;
import bonus_homework.work1.model.Teacher;
import bonus_homework.work1.service.ITeacherService;
import bonus_homework.work1.utils.DateOfBirthException;
import bonus_homework.work1.utils.GenderException;
import bonus_homework.work1.utils.NameException;
import bonus_homework.work1.utils.QualificationException;

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

    private void sortTeacher() {
        boolean isSwap = true;
        for (int i = 0; i < teachers.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getName().compareTo(teachers.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    Teacher newTeacher = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(j));
                    teachers.set(j, newTeacher);
                }
            }
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
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(nameStudent)) {
                System.out.println(teacher);
                check = true;
            }
        }
        if (!check) {
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
        int id;
        while (true) {
            try {
                System.out.print("Mời bạn nhập id: ");
                id = Integer.parseInt(scanner.nextLine());
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
            } catch (NumberFormatException e) {
                System.out.println("Mời bạn nhập lại id");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = (scanner.nextLine());
                String str;
                for (int i = 0; i < name.length(); i++) {
                    str = "";
                    if ((str + name.charAt(i)).matches("\\d+")) {
                        throw new NameException("Tên bạn nhập ko hợp lệ");
                    }
                }

                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh: ");
                dateOfBirth = scanner.nextLine();
                if (!dateOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new DateOfBirthException("Dữ liệu không đúng định dạng");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2022) {
                    throw new DateOfBirthException("Dữ liệu không đúng định dạng");
                }
                break;
            } catch (DateOfBirthException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String gender;
        String genderString;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                gender = scanner.nextLine();
                if (!gender.equals("nam") && (!gender.equals("nu"))) {
                    throw new GenderException("Dữ liệu bạn nhập không hợp lệ");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String qualification;
        String qualificationStr;
        while (true) {
            try {
                System.out.print("Mời bạn nhập trình độ chuyên môn: ");
                qualification = scanner.nextLine();
                for (int i = 0; i < name.length(); i++) {
                    qualificationStr = "";
                    if ((qualificationStr + name.charAt(i)).matches("\\d+")) {
                        throw new QualificationException("Dữ liệu bạn nhập ko hợp lệ");
                    }
                }
                break;
            } catch (QualificationException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Teacher teacher = new Teacher(id, name, dateOfBirth, gender, qualification);
        return teacher;
    }
}