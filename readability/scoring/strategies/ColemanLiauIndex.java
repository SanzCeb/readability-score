package readability.scoring.strategies;

import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;

public class ColemanLiauIndex implements ReadabilityScore {
    @Override
    public double calculateReadabilityScore(WordsRate wordsRate, CharsRate charsRate) {
        double avgNumOfCharsPer100Words = charsRate.calculateCharsRatePer100Words();
        double avgNumOfSentencesPer100Words = wordsRate.sentencesRatePer100Words();
        return 0.0588 * avgNumOfCharsPer100Words - 0.296 * avgNumOfSentencesPer100Words - 15.8;
    }
}
