package readability.scoring;

public class ReadabilityScorer {

    public static Score scoreText(String text) {
        Score score;
        var textLength = text.length();

        if (textLength > 100) {
            score = Score.HARD;
        } else {
            score = Score.EASY;
        }

        return score;
    }
}
