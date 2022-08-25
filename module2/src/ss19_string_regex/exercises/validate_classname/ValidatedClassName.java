package ss19_string_regex.exercises.validate_classname;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatedClassName {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String CLASSNAME_REGEX = "[CAP][\\d]{4}[GHIKLM]";

    public ValidatedClassName() {
        pattern = Pattern.compile(CLASSNAME_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);

        return matcher.matches();
    }

    public static void main(String[] args) {
        ValidatedClassName validateClassName = new ValidatedClassName();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên lớp: ");
        String validClassName = sc.nextLine();
        boolean isvalid = validateClassName.validate(validClassName);
        System.out.println(validClassName + "\t" + isvalid);
    }
}
