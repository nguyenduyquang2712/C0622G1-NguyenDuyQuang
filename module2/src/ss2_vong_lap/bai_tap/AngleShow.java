package ss2_vong_lap.bai_tap;

import java.util.Scanner;

public class AngleShow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw the isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
           int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i <=5 ; i++) {
                        for (int j = 0; j < i ; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < 5 ; i++) {
                        for (int j = 0; j < (5-i) ; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < 5 ; i++) {
                        for (int j = 1; j<=5 ; j++) {
                            if (j>=(5-i)){
                                System.out.print("*");
                            }else System.out.print(" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    for (int i = 0; i < 5 ; i++) {
                        for (int j = 0; j < 5 ; j++) {
                            if(j>=i){
                                System.out.print("*");
                            }
                            else System.out.print(" ");
                    }
                        System.out.println();

                    }
                    break;
                case 3:
                    for (int i = 0; i <=5; i++) {
                        for (int j = 0; j < (11/2) - i ; j++) {
                            System.out.print(" ");
                        }
                        for (int k = 0; k < i*2-1 ; k++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
