package demo.controller;

import bonus_homework.work1.model.Student;

import java.util.Scanner;

public class MainController {
    private static Scanner scanner = new Scanner(System.in);
    private StudentController studentController = new StudentController();
    private TeacherController teacherController = new TeacherController();
    public void mangeMenu(){
        while (true){
            try{
            System.out.println("-------------------------------------------------------------");
            System.out.println("Welcom menu manager main\n" +
                    "1. Manage student menu\n"+
                    "2. Manage teacher menu\n"+
                    "3. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    studentController.manageMenuStudent();
                    break;
                case 2:
                    break;
                case 3:
                    return;
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
