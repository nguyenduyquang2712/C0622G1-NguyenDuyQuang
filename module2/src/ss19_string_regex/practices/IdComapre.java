package ss19_string_regex.practices;

import java.util.Comparator;

public class IdComapre implements Comparator<Infor> {
    @Override
    public int compare(Infor o1, Infor o2) {
        return o1.getId()-o2.getId();
    }
}
