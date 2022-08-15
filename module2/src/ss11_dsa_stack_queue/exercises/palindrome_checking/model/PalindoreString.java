package ss11_dsa_stack_queue.exercises.palindrome_checking.model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindoreString {
    private static Queue<Character> stringQueue = new LinkedList<>();
    private static Stack<Character> stringStack = new Stack<>();

    public PalindoreString() {
    }

    public static void checkPalindoreString(String str) {
        str = str.trim();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            stringStack.push(str.charAt(i));
            stringQueue.add(str.charAt(i));
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(stringStack.pop() == (stringQueue.poll()))) {
                System.out.println("String is not the PalindoreString");
                return;
            }
        }
        System.out.println("String is the PalindoreString");
    }
}

