package ss11_dsa_stack_queue.exercises.reverse_array.model;

import java.util.Stack;

public class StringReverser2 {
    private String inputString;
    private String outputString;

    public StringReverser2(String str) {
        inputString = str;
    }

    public String reverse() {
        Stack<Character> theStack = new Stack();
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            theStack.push(ch);
        }
        outputString = "";
        while (!theStack.isEmpty()) {
            Character ch = theStack.pop();
            outputString += ch;
        }
        outputString = outputString.trim();

        return formString(outputString);
    }

    public String formString(String str) {
        String st = str.trim();
        st = st.replaceAll("\\s+", " ");
        String[] temp = st.split(" ");
        st = "";
        for (int i = 0; i < temp.length; i++) {
            st += temp[i].charAt(0) + temp[i].substring(1);
            if (i < temp.length - 1)
                st += " ";
        }
        return st;
    }
}