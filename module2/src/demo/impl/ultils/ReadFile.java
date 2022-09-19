package demo.impl.ultils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String path) {
        List<String> stringList = new ArrayList<>();
        File file = new File(path);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //skip line 1
//            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not find file!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return stringList;
    }
}
