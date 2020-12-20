package readability.scoring.strategies;

import readability.scoring.grades.GradeLevelScore;
import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;


public class ReadabilityScoreContext {
    private ReadabilityScore readabilityScore;

    public void setStrategy(ReadabilityScore readabilityScore) {
        this.readabilityScore = readabilityScore;
    }

    public String calculateReadabilityScore(WordsRate wordsRate, CharsRate charsRate) {
        var readabilityScore = this.readabilityScore.calculateReadabilityScore(wordsRate, charsRate);
        long age = roundIndex(readabilityScore);
        return String.format("%.2f (about %s year olds)", readabilityScore, GradeLevelScore.getGradeLevel(age));
    }

    private static long roundIndex(double index) {
        return Math.round(index);
    }

}
