package case_study.service.impl.validate;

public class ValidPhoneNumber {
    private static String regex="^[8][4][-][0-9]\\d{8}$";
    public static boolean checkPhoneNumber(String number){
        return number.matches(regex);
    }
}
