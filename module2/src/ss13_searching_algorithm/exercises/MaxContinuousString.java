package ss13_searching_algorithm.exercises;

import java.util.ArrayList;


public class MaxContinuousString {
    public static void main(String[] args) {
        String str = "abcabcdgabmnxyablmntxyz";
        ArrayList<String> list = new ArrayList<>();
        String subString = "" + str.charAt(0);
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                subString += str.charAt(i);
                if (i == str.length() - 2 && str.charAt(i) < str.charAt(i + 1)) {
                    subString += str.charAt(i + 1);
                    list.add(subString);
                    break;
                }
            } else {
                subString += str.charAt(i);
                list.add(subString);
                subString = "";
            }
        }
        String maxSubString = list.get(0);
        for (String item : list) {
            if (item.length() > maxSubString.length()) {
                maxSubString = item;
            }
        }
        System.out.println(maxSubString);
    }


}
