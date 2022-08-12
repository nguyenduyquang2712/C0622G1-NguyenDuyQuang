package ss11_dsa_stack_queue.practices.example;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> animals = new Stack<>();
        animals.push("Giang");
        animals.push("Tien");
        animals.push("Uyen");
        System.out.println("Stack"+animals);
        String element = animals.pop();
        System.out.println("Removed Element: " + element);
        System.out.println("Stack"+animals);
    }
}
