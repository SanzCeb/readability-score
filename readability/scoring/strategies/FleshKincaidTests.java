package readability.scoring.strategies;

import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;

public class FleshKincaidTests implements ReadabilityScore {
    @Override
    public double calculateReadabilityScore(WordsRate wordsRate, CharsRate charsRate) {
        var wordsCount = charsRate.wordsCount();
        var sentencesCount = wordsRate.sentencesCount();
        var syllablesCount = charsRate.countSyllables();
        return 0.39 * wordsCount / sentencesCount + 11.8 * syllablesCount / wordsCount - 15.59;
    }
}
