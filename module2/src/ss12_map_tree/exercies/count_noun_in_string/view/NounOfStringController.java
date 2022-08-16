package ss12_map_tree.exercies.count_noun_in_string.view;

import ss12_map_tree.exercies.count_noun_in_string.model.NounOfString;

import java.util.Scanner;

public class NounOfStringController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 chuỗi: ");
        String string = sc.nextLine();
        NounOfString.checkNounOfString(string);
    }
}
