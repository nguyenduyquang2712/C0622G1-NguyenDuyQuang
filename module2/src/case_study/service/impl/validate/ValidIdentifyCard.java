package case_study.service.impl.validate;

public class ValidIdentifyCard {
    private static String regex="^(\\d{9}|\\d{12})$";
    public static boolean checkIdentifyCard(String identifyCard){
        return identifyCard.matches(regex);
    }
}
