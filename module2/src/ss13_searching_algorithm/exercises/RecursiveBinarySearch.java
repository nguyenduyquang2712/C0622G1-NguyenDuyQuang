package ss13_searching_algorithm.exercises;

import java.util.Arrays;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{3, 6, 2, 5, 8, 9, 11};
        sortArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array, 0, 6, 6));
    }

    public static void sortArray(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (left >= right) {
            return -1;
        }
        if (array[middle] == value) {
            return middle;
        } else {
            if (value > array[middle]) {
                left = (middle + 1);
            } else {
                right = (middle - 1);
            }
            return binarySearch(array, left, right, value);
        }
    }
}

