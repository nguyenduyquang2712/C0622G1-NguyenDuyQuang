package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAddArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử mảng 1:");
        int amount1 = Integer.parseInt(scanner.nextLine());
        int[] array1 = new int[amount1];
        System.out.println("Nhập phần tử mảng 1: ");
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Nhập số lượng phần tử mảng 2: ");
        int amount2 = Integer.parseInt(scanner.nextLine());
        int[] array2 = new int[amount2];
        System.out.println("Nhập phần tử mảng 2: ");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Các phần tử của 2 mảng 1,2 lần lượt là: ");
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        int[] array3 = new int[amount1 + amount2];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = array1.length; i < array3.length; i++) {
            array3[i] = array2[i - array2.length];
        }
        System.out.println("Mảng kết hợp là: ");
        System.out.println(Arrays.toString(array3));
    }
}
