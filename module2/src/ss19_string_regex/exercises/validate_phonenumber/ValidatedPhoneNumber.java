package ss19_string_regex.exercises.validate_phonenumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatedPhoneNumber {

    private static Pattern pattern;
    private Matcher matcher;

    private static final String PHONENUMBER_REGEX = "[(][8][4][)][-][(][0]\\d{9}[)]";


    public ValidatedPhoneNumber() {
        pattern = Pattern.compile(PHONENUMBER_REGEX);
    }

    public boolean isnumberPhone(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }


    public static void main(String[] args) {

        ValidatedPhoneNumber numberPhone = new ValidatedPhoneNumber();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter phone Number you want to check: ");
        String numberPhoneText = sc.nextLine();
        boolean isNumber = numberPhone.isnumberPhone((numberPhoneText));
        System.out.println(numberPhoneText + "\t" + isNumber);
    }
}