package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class MinElementArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử của mảng: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập các phần tử của mảng: ");
        int[] array = new int[amount];
        for (int i = 0; i < amount ; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        int min = array[0];
        for (int element: array) {
            if (element < min){
                min = element;
            }
        }
        System.out.println("Giá trị nhỏ nhất của mảng là: "+min);
    }
}
