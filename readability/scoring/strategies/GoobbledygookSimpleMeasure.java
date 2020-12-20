package readability.scoring.strategies;

import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;

public class GoobbledygookSimpleMeasure implements ReadabilityScore {
    @Override
    public double calculateReadabilityScore(WordsRate wordsRate, CharsRate charsRate) {
        var sentencesCount = wordsRate.sentencesCount();
        var polySyllablesCount = charsRate.countPolySyllables();

        if (sentencesCount == 0) {
            return  0;
        }

        return 1.043 * Math.sqrt(polySyllablesCount * 30 * Math.pow(sentencesCount, -1)) + 3.1291;
    }
}
