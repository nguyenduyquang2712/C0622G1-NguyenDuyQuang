package ss8_cleancode_refractoring.exercise.refactoring.controller;


import ss8_cleancode_refractoring.exercise.refactoring.model.TennisGame;

public class TennisGameTest {
        public static void main(String[] args) {
            TennisGame.showNamePlayer("Hai", "Quang");
            System.out.print("Result: ");
            System.out.print(TennisGame.getScore(3,3));
        }

}
