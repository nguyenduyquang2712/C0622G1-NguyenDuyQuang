package ss11_dsa_stack_queue.exercises.reverse_array.controller;

import ss11_dsa_stack_queue.exercises.reverse_array.model.StringReverser2;

import java.util.Scanner;


public class StringReverserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input String");
        String input = scanner.nextLine();
        System.out.println("initial String: " + input);
        String output;
        StringReverser2 theReverser = new StringReverser2(input);
        output = theReverser.reverse();
        System.out.println("Reversed: " + output);
    }
}
