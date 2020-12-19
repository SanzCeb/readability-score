package readability.scoring;

import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;

import java.util.Arrays;

public class AutomatedReadabilityIndex {
    private final WordsRate wordsRate;
    private final CharsRate charsRate;

    public AutomatedReadabilityIndex(String[] sentences) {
        this.wordsRate = new WordsRate(Arrays.asList(sentences));
        this.charsRate = new CharsRate(wordsRate.getWords());
    }

    public double calculateScore() {
        var charsRateScore = charsRate.calculateCharsRate();
        var wordsRateScore = wordsRate.calculateWordsRate();
        return 4.71 * charsRateScore + 0.5 * wordsRateScore - 21.43;
    }

    public int countWords() {
        return charsRate.wordsCount();
    }

    public int countChars() {
        return charsRate.charsCount();
    }

    public int countSentences() {
        return wordsRate.sentencesCount();
    }

}
