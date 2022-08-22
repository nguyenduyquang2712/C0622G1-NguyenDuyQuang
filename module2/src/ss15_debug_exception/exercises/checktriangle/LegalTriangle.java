package ss15_debug_exception.exercises.checktriangle;

import java.util.Scanner;

public class LegalTriangle {
    private static Scanner scanner = new Scanner(System.in);

    public void checkTriangle(double a, double b, double c) throws IllegalTriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("Exeption: Đây không phải là tam giác");
        } else {
            System.out.println("Đây là một tam giác đúng");
        }
    }

    private static double checkEdge(double i) {
        while (true) {
            try {
                i = Double.parseDouble(scanner.nextLine());
                if (i <= 0) {
                    throw new IllegalTriangleException("Số nhập phải lớn hơn 0, hãy nhập lại ");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.print(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.print("Bạn nhập không phải là số,hãy nhập lại ");
            }

        }
        return i;
    }

    public static void main(String[] args) {
        LegalTriangle triangle = new LegalTriangle();
        double a = 0;
        double b = 0;
        double c = 0;
        System.out.print("Nhap vao canh thu nhat: ");
        a = checkEdge(a);
        System.out.print("Nhap vao canh thu hai: ");
        b = checkEdge(b);
        System.out.print("Nhap vao canh thu ba: ");
        c = checkEdge(c);
        try {
            triangle.checkTriangle(a, b, c);
        } catch (IllegalTriangleException e1) {
            System.out.println(e1.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

