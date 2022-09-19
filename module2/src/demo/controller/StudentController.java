package demo.controller;

import demo.impl.IStudentService;
import demo.impl.service.StudentService;
import demo.model.Student;

import java.util.Scanner;

public class StudentController {
    private Scanner scanner = new Scanner(System.in);
    private IStudentService studentService = new StudentService();
    public void manageMenuStudent() {
        while (true){
            try{
                System.out.println("-----------------------------------------------");
                System.out.println("Welcome menu management Student\n"+
                        "1. Display list student\n"+
                        "2. Add student to the list\n"+
                        "3. Sort student list\n"+
                        "4. Search student in list\n"+
                        "5. Edit infor student\n"+
                        "6. Delete student in list\n"+
                        "7. Return main menu\n"+
                        "8. Exit");
                System.out.println("Please Enter 1->7");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        studentService.displayListStudent();
                        break;
                    case 2:
                        studentService.addStudent();
                        break;
                    case 3:
                        studentService.sortStudentList();
                        break;
                    case 4:
                        studentService.searchStudent();
                        break;
                    case 5:
                        studentService.editStudent();
                        break;
                    case 6:
                        studentService.deleteStudent();
                        break;
                    case 7 :
                        return;
                    case 8:
                        System.exit(0);
                }
            }
            catch (NumberFormatException e){
                System.out.println("Please reenter number");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}
