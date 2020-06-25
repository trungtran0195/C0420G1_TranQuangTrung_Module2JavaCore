package B7_CleanCodeAndRefactoring.BaiTap.Refactoring.src;

public class TennisGame {

    public static String getScore(String player1Name, String player2Name, int player1score, int player2score) {
        String finalResult = "";
        int tempScore = 0;
        boolean isDiffirentScore = player1score != player2score;
        if (isDiffirentScore) {
            if (player1score < 4) {
                if (player2score >= 4) {
                    int minusResult = player1score - player2score;
                    if (minusResult == 1) finalResult = "Advantage player1";
                    else if (minusResult == -1) finalResult = "Advantage player2";
                    else if (minusResult >= 2) finalResult = "Win for player1";
                    else finalResult = "Win for player2";
                } else {
                    finalResult = getString(player1score, player2score, finalResult);
                }
            } else {
                int resultDifferent = player1score - player2score;
                if (resultDifferent == 1) finalResult = "Advantage player1";
                else if (resultDifferent == -1) finalResult = "Advantage player2";
                else if (resultDifferent >= 2) finalResult = "Win for player1";
                else finalResult = "Win for player2";
            }
        } else {
            switch (player1score) {
                case 0:
                    finalResult = "Love-All";
                    break;
                case 1:
                    finalResult = "Fifteen-All";
                    break;
                case 2:
                    finalResult = "Thirty-All";
                    break;
                case 3:
                    finalResult = "Forty-All";
                    break;
                default:
                    finalResult = "Deuce";
                    break;

            }
        }
        return finalResult;
    }

    public static String getString(int player1score, int player2score, String score) {
        int tempScore;
        StringBuilder scoreBuilder = new StringBuilder(score);
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1score;
            else {
                scoreBuilder.append("-");
                tempScore = player2score;
            }
            switch (tempScore) {
                case 0:
                    scoreBuilder.append("Love");
                    break;
                case 1:
                    scoreBuilder.append("Fifteen");
                    break;
                case 2:
                    scoreBuilder.append("Thirty");
                    break;
                case 3:
                    scoreBuilder.append("Forty");
                    break;
            }
        }
        score = scoreBuilder.toString();
        return score;
    }
}
