package readability.scoring.strategies;

import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;

public class AutomatedReadabilityIndex implements ReadabilityScore{
    @Override
    public double calculateReadabilityScore(WordsRate wordsRate, CharsRate charsRate) {
        var charsRateScore = charsRate.calculateCharsRate();
        var wordsRateScore = wordsRate.calculateWordsRate();
        return 4.71 * charsRateScore + 0.5 * wordsRateScore - 21.43;
    }
}
