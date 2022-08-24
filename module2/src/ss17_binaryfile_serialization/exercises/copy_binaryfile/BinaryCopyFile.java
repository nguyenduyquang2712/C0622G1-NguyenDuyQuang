package ss17_binaryfile_serialization.exercises.copy_binaryfile;

import sun.net.www.content.text.Generic;

import java.io.*;

public class BinaryCopyFile implements Serializable {
    public static void main(String[] args) throws IOException {
        File fileSource = new File("src\\ss17_binaryfile_serialization\\exercises\\copy_binaryfile\\text.txt");
        if (!fileSource.exists()) {
            System.out.println("File nguồn ko tồn tại, tự động tạo file");
            fileSource.createNewFile();
        } else {
            System.out.println("File nguồn đã tồn tại");
        }
        FileOutputStream fiswrite = new FileOutputStream(fileSource);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fiswrite);
        objectOutputStream.writeObject("we cant but i can");
        objectOutputStream.close();
        FileInputStream fis = new FileInputStream(fileSource);

        File fileTarget = new File("src\\ss17_binaryfile_serialization\\exercises\\copy_binaryfile\\text2.txt");
        if (!fileTarget.exists()) {
            System.out.println("file đích chưa tồn tại, tự động tạo file");
            fileTarget.createNewFile();
        } else {
            System.out.println("File đích đã tồn tại");
        }
        FileOutputStream fos = new FileOutputStream(fileTarget);
        int i = -1;
        byte[] bytes = new byte[1024];// Đọc 10 byte 1 thời điểm
        while ((i = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, i);
        }
        long countByte = fileSource.length();
        fis.close();
        fos.close();
        System.out.println("Copy file hoàn thành");
        System.out.println("Số bytes đếm đc là: " + countByte + " Bytes");
    }
}
