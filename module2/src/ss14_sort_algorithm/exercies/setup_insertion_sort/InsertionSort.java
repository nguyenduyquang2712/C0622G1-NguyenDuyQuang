package ss14_sort_algorithm.exercies.setup_insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 6, 4, 67, 2, 6, 267, 74, 7, 6};
        System.out.println("Mảng ban đầu là");
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println("Mảng sau khi sắp xếp là");
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] arr) {
        int key;
        int j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
    }
}
