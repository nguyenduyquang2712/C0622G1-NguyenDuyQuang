package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class MaxElementMatrixArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Khởi tạo ma trận số nguyên");
        System.out.println("Nhập số hàng ma trận");
        int rowArray = scanner.nextInt();
        System.out.println("Nhập số cột ma trận");
        int colArray = scanner.nextInt();
        double[][] MatrixArray = new double[rowArray][colArray];
        System.out.println("Nhập các phần tử ma trận");
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
        int rowMax = 0;
        int colMax = 0;
        double maxElement = MatrixArray[0][0];
        for (int i = 0; i < rowArray ;  i++) {
            for (int j = 0; j < colArray ; j++) {
                if(maxElement<MatrixArray[i][j]){
                    maxElement = MatrixArray[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }
        System.out.printf("Phần tử lớn nhất của mảng là: %.2f \n Tại vị trí: hàng: %d, cột: %d ",maxElement,rowMax+1,colMax+1);
    }
}
