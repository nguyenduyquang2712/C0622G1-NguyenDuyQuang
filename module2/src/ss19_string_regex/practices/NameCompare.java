package ss19_string_regex.practices;

import java.util.Comparator;

public class NameCompare implements Comparator<Infor> {

    @Override
    public int compare(Infor o1, Infor o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
