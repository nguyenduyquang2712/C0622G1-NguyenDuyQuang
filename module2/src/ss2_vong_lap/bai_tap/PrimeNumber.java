package ss2_vong_lap.bai_tap;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in: ");
        int amount = scanner.nextInt();
        System.out.println("Kết quả là: ");
        int count;
        for (int i = 1,countNumber = 0;countNumber < amount  ; i++) {
            count =0;
            for (int j = 1; j <= i ; j++) {
                if(i%j==0){
                    count++;
            }
        }
            if(count==2){
                System.out.print(i+" ");
                countNumber++;
            }
        }
    }
}
