package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class SumOfbBiasArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Khởi tạo mảng ma trận vuông");
        System.out.println("Nhập số hàng và cột ");
        int number = Integer.parseInt(scanner.nextLine());
        double[][] MatrixArray = new double[number][number];
        System.out.println("Nhấp các phần tử ma trận");
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                MatrixArray[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Mảng vừa nhập: ");
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(MatrixArray[i][j] + "\t\t");
            }
            System.out.println("\n");

        }
        double sumOfbBiasArray=0;
        for (int i = 0; i < MatrixArray.length ; i++) {
            for (int j = 0; j < MatrixArray.length ; j++) {
                if(i==j){
                    sumOfbBiasArray+= MatrixArray[i][j];
                }
            }
        }
        System.out.printf("Tổng các số ở đường chéo chính của ma trận là: %.2f",sumOfbBiasArray);
    }
}
