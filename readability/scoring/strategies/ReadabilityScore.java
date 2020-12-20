package readability.scoring.strategies;

import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;

public interface ReadabilityScore {
    double calculateReadabilityScore(WordsRate wordsRate, CharsRate charsRate);
}
