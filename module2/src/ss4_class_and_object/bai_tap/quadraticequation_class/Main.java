package ss4_class_and_object.bai_tap.quadraticequation_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter constant a = ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter constant b = ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter constant c = ");
        double c = Double.parseDouble(scanner.nextLine());
        System.out.printf("QuadraticEquation is: %.2fx2 + %.2fx + %.2f = 0\n",a,b,c);
        QuadraticEquation quadraticequation = new QuadraticEquation();
        quadraticequation.setConstantA(a);
        quadraticequation.setConstantB(b);
        quadraticequation.setConstantC(c);
        if (quadraticequation.getDiscriminant()>0){
            System.out.printf("The equation has two roots \n root1 = %.2f\n root2 = %.2f",quadraticequation.getRoot1(),quadraticequation.getRoot2());

        } else if (quadraticequation.getDiscriminant()==0){
            System.out.printf("The equation has one root : %.2f\n",quadraticequation.getRoot1());
        } else {
            System.out.println("The equation has no real root ");
        }


    }
}
