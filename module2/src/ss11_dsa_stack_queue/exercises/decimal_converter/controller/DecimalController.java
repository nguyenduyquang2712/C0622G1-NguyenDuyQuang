package ss11_dsa_stack_queue.exercises.decimal_converter.controller;

import ss11_dsa_stack_queue.exercises.decimal_converter.model.DecimalConverter;

import java.util.Scanner;

public class DecimalController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number need to convert");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Number to binary");
        DecimalConverter.convertNumber(number);
    }
}
