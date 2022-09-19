package ss19_string_regex.practices;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileInfo {
    public static List<String> readFile(String path){
        List<String> strings = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader= null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while (true){
            try {
                if ((line = bufferedReader.readLine()) == null) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            strings.add(line);
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
    public static List<Infor> readFileInfo(String path){
        List<String> strings = readFile(path);
        List<Infor> infors = new ArrayList<>();
        String[] info;
        for(String line:strings){
            if(!line.equals("")){
                info = line.split(",");
                infors.add(new Infor(Integer.parseInt(info[0]),info[1]));
            }
        }
        return infors;
    }
}
