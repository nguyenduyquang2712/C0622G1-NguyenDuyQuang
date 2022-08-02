package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeletingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử mảng muốn khởi tạo: ");
        int amount = scanner.nextInt();
        int[] array = new int[amount];
        System.out.println("Nhập các phẩn tử mảng: ");
        for (int i = 0; i < amount; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Mảng khởi tạo là: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập phần tử muốn xóa: ");
        int number = scanner.nextInt();
            int countNumber = 0;
            for (int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    System.out.println("phần tử cần xóa tại vị trí " + i);
                    countNumber++;
                }
            }
            int countCheck=0;
            for (int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    countCheck++;
                    for (int j = i; j < array.length - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    array[array.length - 1] = 0;
                    i--;
                }
                if (countCheck == countNumber) {
                    break;
                }
            }

        System.out.println("Mảng mới xóa phần tử là:");
        System.out.println(Arrays.toString(array));

    }
}
