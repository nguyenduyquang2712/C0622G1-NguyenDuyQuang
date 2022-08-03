package ss1_introduction.bai_tap;

import java.util.Scanner;

public class ConvertionNumber {
    public static void main(String[] args) {
        String[] numbersUnits = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] numbersTens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        String[] numString = Integer.toString(number).split("", 0);
        switch (numString.length) {
            case 1:
            case 2:
                if (number == 0) {
                    System.out.println("Zero");
                } else if (number < 20) {
                    System.out.print(numbersUnits[number]);
                } else {
                    System.out.print(numbersTens[Integer.parseInt(numString[0]) - 2] + ' ' + numbersUnits[Integer.parseInt(numString[1])]);
                }
                break;
            case 3:
                System.out.print(numbersUnits[Integer.parseInt(numString[0])] + " hundred and ");
                number -= Integer.parseInt(numString[0]) * 100;
                if (number == 0) {
                    System.out.println("Zero");
                } else if (number < 20) {
                    System.out.print(numbersUnits[number]);
                } else {
                    System.out.print(numbersTens[Integer.parseInt(numString[1]) - 2] + ' ' + numbersUnits[Integer.parseInt(numString[2])]);
                }
                break;
            default:
                System.out.println("out of ability");
        }
    }
}