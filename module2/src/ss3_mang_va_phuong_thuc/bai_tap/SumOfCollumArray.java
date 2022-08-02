package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class SumOfCollumArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Khởi tạo mảng 2 chiều với kích thước cho trước");
        System.out.println("Nhập số hàng ");
        int rowArray = scanner.nextInt();
        System.out.println("Nhập số cột ");
        int colArray = scanner.nextInt();
        double[][] MatrixArray = new double[rowArray][colArray];
        System.out.println("Nhấp các phần tử ma trận");
        for (int i = 0; i < rowArray; i++) {
            for (int j = 0; j < colArray; j++) {
                MatrixArray[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < rowArray; i++) {
            for (int j = 0; j < colArray; j++) {
                System.out.print(MatrixArray[i][j] + "\t\t");
            }
            System.out.println("\n");

        }
        System.out.println("Nhập số cột muốn tính tổng:");
        int colNumber = scanner.nextInt();
        double sum = 0;
        for (int i = 0; i < rowArray ; i++) {
            sum+= MatrixArray[i][colNumber-1];
        }
        System.out.printf("Tổng các phần tử tại cột thứ %d là: %.2f",colNumber,sum);
    }
}
