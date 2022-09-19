package demo.impl.ultils;

import java.io.*;

public class WriteFile {
    public static void writeFile(String path, String data) {
        File file = new File(path);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
