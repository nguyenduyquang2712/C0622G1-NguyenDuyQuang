package ss13_searching_algorithm.practices.practices1;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,4,4,7,4,6,8,2};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }

}