package case_study.service.impl.validate;

public class ValidNamePerson {
//    private static final String regex = "^[A-Za-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ\\s]{5,50}$";
    private static final String regex = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";
    public static boolean checkName(String name){
        if(!name.matches("\\D{5,50}")){
            return false;
        }
            return name.matches(regex);
    }
}
