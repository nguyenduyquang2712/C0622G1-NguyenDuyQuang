package ss11_dsa_stack_queue.exercises.bracket_checking.controller;

import ss11_dsa_stack_queue.exercises.bracket_checking.model.BracketChecking;

import java.util.Scanner;

public class BracketController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression want to check");
        String expression = scanner.nextLine();
        System.out.println("The valid bracket is " + BracketChecking.checkBracket(expression));
    }
}
