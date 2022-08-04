package ss4_class_and_object.bai_tap.stop_watch_class;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.setStartTime();
        stopWatch.start();
        System.out.println("Đang đếm thời gian");
        int[] array = new int[100000];   // khởi tạo random 100000 số
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)Math.floor(Math.random()*100000);
        }
        while (true) {
            sort(array); // dùng hàm Sắp xếp định nghĩa
            for (int i = 0; i < array.length ; i++) {
                System.out.print(array[i] +" ");
            }
            System.out.println();
            stopWatch.stop();
            stopWatch.getElapsedTime();
            break;
        }

    }

    public static void sort(int[] arr) {
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < arr.length - 1; i++) {

            // Tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            // Hoán đổi phần tử nhỏ nhất và phần tử đầu tiên
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}

