package ss19_string_regex.practices;

import case_study.service.utils.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Infor infor1 = new Infor(1, "Linh");
        List<Infor> infors = new ArrayList<>();
        infors.add(new Infor(1, "quang"));
        infors.add(new Infor(4, "linh"));
        infors.add(new Infor(2, "hoang"));
        infors.add(new Infor(1, "hoang"));
        Collections.sort(infors, new IdComapre());
        for (Infor infor : infors) {
            System.out.println(infor);
        }
        for (Infor infor : infors) {
            if (infor.equals(infor1)) {
                System.out.println(true);
            }
        }

//        }
//        Collections.sort(infors,new NameCompare());
//        for(Infor infor:infors){
//            System.out.println(infor);
//        }
//        WriteFileInfo.writeFileInfo("src\\ss19_string_regex\\practices\\Info.csv",infors);
//        List<Infor> infors2 = new ArrayList<>();
//        try {
//            infors2 = ReadFileInfo.readFileInfo("src\\ss19_string_regex\\practices\\Info.csv");
//            if(infors.size()==0){
//                throw new FileNotFoundException("lol");
//            }
//            for (Infor infor : infors2) {
//                System.out.println(infor);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        System.out.println(true);
        }
    }

