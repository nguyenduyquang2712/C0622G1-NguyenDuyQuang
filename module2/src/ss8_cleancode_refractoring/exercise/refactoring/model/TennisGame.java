package ss8_cleancode_refractoring.exercise.refactoring.model;

public class TennisGame {
    static final int LOVE = 0;
    static final int SCORE_15 = 1;
    static final int SCORE_30 = 2;
    static final int SCORE_40 = 3;

    public static void showNamePlayer(String nameOfPlayer1, String nameOfPlayer2) {
        System.out.println("Name of Player1: " + nameOfPlayer1 + "\n" + "Name of Player2: " + nameOfPlayer2);
    }

    public static String getScore(int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";
        int tempScore;
        if (scoreOfPlayer1 == scoreOfPlayer2) {
            score = checkDeuce(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= 4 || scoreOfPlayer2 >= 4) {
            score = checkAdvantagePlayer(scoreOfPlayer1, scoreOfPlayer2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) {
                    tempScore = scoreOfPlayer1;
                } else {
                    score += "-";
                    tempScore = scoreOfPlayer2;
                }
                switch (tempScore) {
                    case LOVE:
                        score += "Love";
                        break;
                    case SCORE_15:
                        score += "Fifteen";
                        break;
                    case SCORE_30:
                        score += "Thirty";
                        break;
                    case SCORE_40:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    public static String checkDeuce(int scoreOfPlayer) {
        switch (scoreOfPlayer) {
            case LOVE:
                return "Love-All";
            case SCORE_15:
                return "Fifteen-All";

            case SCORE_30:
                return "Thirty-All";
            case SCORE_40:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String checkAdvantagePlayer(int score1, int score2) {
        int minusResult = score1 - score2;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}
