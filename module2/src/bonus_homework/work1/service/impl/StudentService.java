package bonus_homework.work1.service.impl;

import bonus_homework.work1.model.Student;
import bonus_homework.work1.service.IStudentService;
import bonus_homework.work1.utils.*;

import java.io.IOException;
import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static String PATH_NAME_FILE_STUDENT = "src\\bonus_homework\\work1\\data\\student.txt";

//    static {
//        students.add(new Student(1, "Nguyen van quang", "12/12/12", "nam", "c0622g1", 1));
//        students.add(new Student(2, "Nguyen van hai", "12/12/12", "nam", "c0622g1", 7));
//        students.add(new Student(4, "Le dinh anh", "12/2/12", "nu", "c0622g1", 6));
//        students.add(new Student(5, "Nguyen binh", "11/11/11", "nam", "c0922g1", 5));
//    }

    @Override
    public void addStudent() throws IOException {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Thêm mới học sinh thành công");
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
    }

    @Override
    public void showAllStudent() throws IOException {
        sortStudent();
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }

    private void sortStudent() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        boolean isSwap = true;
        Student newStudent;
        for (int i = 0; i < students.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getName().compareTo(students.get(j + 1).getName()) > 0) {
                    isSwap = true;
                    newStudent = students.get(j + 1);
                    students.set(j + 1, students.get(j));
                    students.set(j, newStudent);
                }
            }
        }
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
    }


    @Override
    public void removeStudent() throws IOException {

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
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
    }

    @Override
    public void changeInfoStudent() throws IOException {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("không tìm thấy đối tượng ");
        } else {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == student.getId()) {
                    students.set(i, this.infoStudent());
                }
            }
        }
        writeStudentFile(PATH_NAME_FILE_STUDENT, students);
    }

    @Override
    public void findInforStudent() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        while (true) {
            System.out.println("1. Tìm kiếm sinh viên theo ID");
            System.out.println("2. Tìm kiếm sinh viên theo tên");
            System.out.println("3. Exit");
            System.out.println("Mời bạn nhập tùy chọn 1->3");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    findInforStudentById();
                    break;
                case 2:
                    findInforStudentByName();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Nhập lại lựa chọn");
                    break;
            }
        }
    }

    private void findInforStudentById() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        System.out.println("Nhập ID cần tìm kiếm: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println(" Không tìm thấy id");
    }

    private void findInforStudentByName() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
        System.out.println("Nhập name student cần tìm kiếm");
        String nameStudent = scanner.nextLine();
        boolean check = false;
        for (Student student : students) {
            if (student.getName().contains(nameStudent)) {
                System.out.println(student);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Ko tìm thấy tên cần tìm");
        }
    }


    private Student findStudent() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
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

    private Student infoStudent() throws IOException {
        students = readStudentFile(PATH_NAME_FILE_STUDENT);
//        int id;
//        while (true) {
//            try {
//                System.out.print("Mời bạn nhập id: ");
//                id = Integer.parseInt(scanner.nextLine());
//                boolean check = true;
//                for (Student student : students) {
//                    if (student.getId() == id) {
//                        System.out.println("ID bị trùng, mời bạn nhập lại id");
//                        id = Integer.parseInt(scanner.nextLine());
//                        check = false;
//                        break;
//                    }
//                }
//                if (check) break;
//            } catch (NumberFormatException e) {
//                System.out.println("Mời bạn nhập lại id");
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
        int id;
        if (students.size() == 0) {
            id = 1;
        } else {
            int nextId = students.get(0).getId();
            for (Student student : students) {
                if (nextId < student.getId()) {
                    nextId = student.getId();
                }
            }
            id = nextId + 1;
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
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2016) {
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
        String nameClass;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên lớp: ");
                nameClass = scanner.nextLine();
                if (!nameClass.matches("\\D+\\d+\\d+\\d+\\d+\\D+\\d")) {
                    throw new NameClassException("Tên lớp không hợp lệ");
                }
                break;
            } catch (NameClassException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                if (point < 0 || point > 100) {
                    throw new PointException("Điểm bạn nhập không hợp lệ");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng định dạng");
            } catch (PointException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        Student student = new Student(id, name, dateOfBirth, gender, nameClass, point);
        return student;
    }

    public static void writeStudentFile(String path, List<Student> students) throws IOException {
        String data = "";
        for (Student student : students) {
            data += student.toString();
            data += "\n";
        }

        WriteFileUtil.writeFile(path, data);
    }


    public static List<Student> readStudentFile(String path) throws IOException {
        List<String> strings = ReadFileUtil.readFile(path);
        List<Student> students = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            students.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], Double.parseDouble(info[5])));
        }
            return students;
    }
}