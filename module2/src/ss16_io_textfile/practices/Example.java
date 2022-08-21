package ss16_io_textfile.practices;

import java.io.File;
import java.io.IOException;

public class Example {
    public static void main(String[] args) throws IOException {
        File folder = new File("src/ss16_io_textfile/practices/test.txt");
        System.out.println(folder.exists());
    }
}