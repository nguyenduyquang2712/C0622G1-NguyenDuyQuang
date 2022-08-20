package ss15_debug_exception.exercises.checktriangle;

import java.util.Scanner;

public class LegalTriangle {
    private static Scanner scanner = new Scanner(System.in);

    public void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Exeption: Đây không phải là tam giác");
        } else {
            System.out.println("Đây là một tam giác đúng");
        }
    }

    public static void main(String[] args) {
        LegalTriangle triangle = new LegalTriangle();
        try {
            System.out.print("Nhap vao canh thu nhat: ");
            int a = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap vao canh thu hai: ");
            int b = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhap vao canh thu ba: ");
            int c = Integer.parseInt(scanner.nextLine());
            triangle.checkTriangle(a, b, c);
        } catch (IllegalTriangleException e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e) {
            System.out.println("Sai định dạng số!");
        }
    }
}

