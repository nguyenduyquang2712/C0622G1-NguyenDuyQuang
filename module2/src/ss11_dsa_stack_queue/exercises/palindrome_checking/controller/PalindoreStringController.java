package ss11_dsa_stack_queue.exercises.palindrome_checking.controller;

import ss11_dsa_stack_queue.exercises.palindrome_checking.model.PalindoreString;

import java.util.Scanner;

public class PalindoreStringController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String you want to check");
        String inputString = scanner.nextLine();
        PalindoreString.checkPalindoreString(inputString);
    }
}
