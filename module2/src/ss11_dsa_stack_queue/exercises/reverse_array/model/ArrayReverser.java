package ss11_dsa_stack_queue.exercises.reverse_array.model;

import java.util.Arrays;
import java.util.Stack;

public class ArrayReverser {
    public ArrayReverser() {

    }

    public int[] reverse(int[] array) {
        Stack<Integer> list = new Stack<>();
        System.out.println(Arrays.toString(array));
        for (int value : array) {
            list.push(value);
        }
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = list.pop();
        }
        return newArray;
    }
}

