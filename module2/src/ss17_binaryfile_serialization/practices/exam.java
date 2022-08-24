package ss17_binaryfile_serialization.practices;

import java.io.*;

public class exam {
    public static void main(String[] args) throws IOException {
        try (

                // Create an output stream to the file

                FileOutputStream output = new FileOutputStream("src\\ss17_binaryfile_serialization\\practices\\CodeGym.txt");

        ) {

            // Output values to the file

            for (int i = 1; i <= 10; i++)

                output.write(i);

        }

    }
}
