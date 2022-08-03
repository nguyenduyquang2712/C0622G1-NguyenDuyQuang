package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayAddingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử mảng muốn khởi tạo: ");
        int amount = Integer.parseInt(scanner.nextLine());
        int[] array = new int[amount];
        System.out.println("Nhập các phẩn tử mảng: ");
        for (int i = 0; i < amount ; i++) {
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng khởi tạo là: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập phần tử cần chèn: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vị trí cần chèn: ");
        int index = Integer.parseInt(scanner.nextLine());
        while (index<=-1 || index>array.length){
            System.out.println("Không chèn được phần tử vào mảng");
            System.out.println("Nhập lại vị trí cần chèn: ");
            index = Integer.parseInt(scanner.nextLine());
        }
        for (int i = array.length-1; i > index ; i--) {
            array[i] = array[i-1];

        }
        array[index] = number;
        System.out.println(Arrays.toString(array));
    }
}
