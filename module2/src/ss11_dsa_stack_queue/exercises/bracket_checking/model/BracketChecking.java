package ss11_dsa_stack_queue.exercises.bracket_checking.model;


import java.util.Stack;

public class BracketChecking {
    private static Stack<Character> characterStack = new Stack<>();

    public BracketChecking() {

    }

    public static boolean checkBracket(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                characterStack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                if (characterStack.isEmpty()) {
                    return false;
                } else if (characterStack.pop() != '(') {
                    return false;
                }
            }
        }
        return characterStack.isEmpty();
    }


}
