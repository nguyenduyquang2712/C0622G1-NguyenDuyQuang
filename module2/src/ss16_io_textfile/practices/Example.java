package ss16_io_textfile.practices;

import java.io.*;

public class Example {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;
        try {
            try {
                in = new FileReader("src/ss16_io_textfile/practices/Example1.txt");
            } catch (FileNotFoundException e) {
                System.out.println("Không tìm thấy file nguồn");
            }
            try {
                out = new FileWriter("src/ss16_io_textfile/practices/Example2.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        }
    }

