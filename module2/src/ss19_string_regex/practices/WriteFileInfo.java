package ss19_string_regex.practices;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFileInfo {
    public static void WriteFile(String path, String data){
        File file = new File(path);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeFileInfo(String path, List<Infor> inforList){
        String data ="";
        for(Infor infor:inforList){
            data += infor.getInfo()+"\n";
        }
            WriteFile(path,data);
    }
}
