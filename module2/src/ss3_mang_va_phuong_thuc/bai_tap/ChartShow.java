package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Scanner;

public class ChartShow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi  ");
        String stringCheck = scanner.nextLine();
        System.out.println("Nhập 1 kí tự cần check");
        String charCheck = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <stringCheck.length() ; i++) {
            if(stringCheck.charAt(i)==charCheck.charAt(0)){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện kí tự trong chuỗi là: "+count);



    }
}
