package ss1_introduction.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float widtd;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Width: ");
        widtd = scanner.nextFloat();
        System.out.println("Enter Height: ");
        height = scanner.nextFloat();
        float area = widtd * height;
        System.out.println("Area is: "+area);
    }
}
