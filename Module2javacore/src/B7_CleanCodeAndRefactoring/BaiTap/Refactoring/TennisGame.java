package B7_CleanCodeAndRefactoring.BaiTap.Refactoring;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int THIRTY = 2;
    public static final int FIFTEEN = 1;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int score1, int score2) {
        String score = "";
        int tempScore = 0;
        boolean isScoreEqual = score1 == score2;
        if (isScoreEqual) {
            score = getResultScoreEqual(score1);
        } else {
            boolean isScoreAdvance = score1 >= 4 || score2 >= 4;
            if (isScoreAdvance) {
                score = getResultScoreAdvance(score1, score2);
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = score1;
                    else {
                        score += "-";
                        tempScore = score2;
                    }
                    score = getResultScoreNormal(tempScore);
                }
            }
        }
        return score;
    }

    public static String getResultScoreNormal(int score) {
        String result = "";
        switch (score) {
            case LOVE:
                result += "Love";
                break;
            case FIFTEEN:
                result += "Fifteen";
                break;
            case THIRTY:
                result += "Thirty";
                break;
            case FORTY:
                result += "Forty";
                break;
            default:
                result += "Dauce";
        }
        return result;
    }

    public static String getResultScoreAdvance(int score1, int score2) {
        String score;
        int minusResult = score1 - score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    public static String getResultScoreEqual(int score1) {
        String score;
        switch (score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
}
