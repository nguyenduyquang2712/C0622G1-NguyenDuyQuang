package ss16_io_textfile.exercises.read_file.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("src\\ss16_io_textfile\\exercises\\read_file\\nation.csv"));

            while ((line = br.readLine()) != null) {
                printNation(parseCsvLine(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void printNation(List<String> nation) {
        System.out.println(
                "Nation [id= "
                        + nation.get(0)
                        + ", code= " + nation.get(1)
                        + " , name=" + nation.get(2)
                        + "]");
    }
}

