package ss11_dsa_stack_queue.exercises.reverse_array.controller;

import ss11_dsa_stack_queue.exercises.reverse_array.model.ArrayReverser;

import java.util.Arrays;

public class ArrayReverserTest {
    public static void main(String[] args) {
        int[] array = new int[]{1,3,4,5,6};
        ArrayReverser arrayReverser = new ArrayReverser();
        System.out.println(Arrays.toString(arrayReverser.reverse(array)));
    }
}
