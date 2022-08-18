package ss14_sort_algorithm.exercies.illustrate_insertion_sort;

import java.util.Arrays;

public class InsertionSortShow {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 2, 10, 6, 8, 11, 17};
        System.out.println("Mảng ban đầu: ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Tiến hành sắp xếp, giá trị lấy ra để chèn gọi tắt là key\n");
        for (int i = 1; i < arr.length; i++) {
            System.out.println("Sắp xếp lần thứ " + i);
            System.out.println("phần tử lấy ra tại ví trí " + i + " để chèn có giá trị " + arr[i]);
            int key = arr[i];// lấy phần tử ra để chèn vào mảng đã sắp xếp từ nhỏ đến lớn trước đó bắt đầu với vị trí thứ i=1
            int j; // tạo biến đếm xét phẩn tử i với mảng đã sắp xếp trước đó, mảng đã sắp xếp trước đó có 1 phần tử là arr[0];
            for (j = i - 1; j >= 0 && arr[j] > key; j--) {  //tạo vòng lặp so sánh phần tử i với mảng con trước i đã sắp xếp thứ tự
                System.out.println("Giá trị tại vị trí " + j + " có giá trị " + arr[j] + " > key");
                arr[j + 1] = arr[j];// nếu phần tử tại vị trí j > key thì đẩy nó quả phải tại vị trí j+1, tới bước lặp tiếp theo
                System.out.println("Đẩy giá trị từ " + j + " qua vị trí " + (j + 1));
                System.out.println("Vị trí thứ " + (j + 1) + " có trị mới là " + arr[j + 1]);
            }
            arr[j + 1] = key;// nếu phần tử tại vị trí j<key thì chèn key vào vị trí sau j để tiếp tục tạo mảng nhỏ đã có sắp xếp, sau đó tiếp tục chọn phần tử i tiếp theo để xét
            System.out.println("Key có giá trị " + key + " được chèn vào vị trí " + (j + 1));
            System.out.println("mảng con sau sắp xếp lần thứ " + i);
            for (int k = 0; k <= i; k++) {
                System.out.print(arr[k] + "\t");
            }
            System.out.println();
            System.out.println();
        }
        // Lần lượt lấy phần tử ra để chèn vào mảng con cũ cho đến hết vòng lặp i
        System.out.println("Mảng đã sắp xếp theo sắp xếp chèn: ");
        System.out.println(Arrays.toString(arr));
    }
}
