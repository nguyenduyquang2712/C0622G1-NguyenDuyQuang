package ss11_dsa_stack_queue.exercises.decimal_converter.model;

import java.util.Stack;

public class DecimalConverter {
    private static Stack<Integer> integerStack = new Stack<>();

    public DecimalConverter() {
    }

    public static void convertNumber(int number) {
        while (number != 0) {
            integerStack.push(number % 2);
            number /= 2;
        }
        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }
    }
}
