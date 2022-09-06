package case_study.service.impl.validate;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Validdate {
    private static LocalDate dateNow = LocalDate.now();

    public static boolean checkDateofBirth(String day) {
        LocalDate date;
        if (!day.matches("^\\d\\d[/]\\d\\d[/]\\d{4}")) {
            return false;
        }
        try {
            date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
//            Period periodToNextJavaRelease = Period.between(date, dateNow);
//            if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
//                return true;
//            }
        } catch (DateTimeParseException e){
            return false;
        }
        catch (Exception e){
            return false;
        }
        Period periodToNextJavaRelease = Period.between(date, dateNow);
        if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
            return true;
        }
        return false;
    }
    public static boolean checkDate(String day){
        LocalDate date;
        if (!day.matches("^\\d\\d[/]\\d\\d[/]\\d{4}")) {
            return false;
        }
        try {
            date = LocalDate.parse(day, DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
//            Period periodToNextJavaRelease = Period.between(date, dateNow);
//            if (periodToNextJavaRelease.getYears() < 100 && periodToNextJavaRelease.getYears() > 18) {
//                return true;
//            }
            if(date.isBefore(dateNow)){
                return false;
            }
            return true;
        } catch (DateTimeParseException e){
            return false;
        }
        catch (Exception e){
            return false;
        }
    }
    public static LocalDate convertDay(String day){
        LocalDate convertDay = LocalDate.parse(day,DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT));
        return convertDay;
    }

}
