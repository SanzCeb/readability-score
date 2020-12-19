package readability.scoring.rates;

import java.util.Collection;

public class CharsRate {
    private final Collection<String> words;

    public CharsRate(Collection<String> words) {
        this.words = words;
    }

    public int charsCount() {
        return words.stream()
                .mapToInt(String::length)
                .sum();
    }

    public int wordsCount() {
        return words.size();
    }

    public double calculateCharsRate() {
        return words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }
}
