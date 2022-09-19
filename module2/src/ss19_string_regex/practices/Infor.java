package ss19_string_regex.practices;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Infor {
    private int id;
    private String name;

    public Infor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Infor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getInfo(){
        return String.format("%s,%s",id,name);
    }
    @Override
    public String toString() {
        return "Infor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Infor){
//            if(this.getId() == ((Infor) obj).getId()){
//                return true;
//            }
//        }
//        return false;
//    }
}
