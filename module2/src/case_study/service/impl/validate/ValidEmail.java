package case_study.service.impl.validate;

public class ValidEmail {
    private static String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    public static boolean checkEmail(String email){
        return email.matches(regex);
    }
}
