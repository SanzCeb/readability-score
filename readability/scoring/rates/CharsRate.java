package readability.scoring.rates;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CharsRate {
    private final List<String> words;
    private final static Pattern VOWEL_PATTERN = Pattern.compile("[a-zA-z]?[aeiouyAEIOUY][a-zA-Z]|[a-zA-Z][aiouyAIOUY]");

    public CharsRate(List<String> words) {
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

    public long countSyllables() {
        return words.stream().map(VOWEL_PATTERN::matcher)
                .map(Matcher::results)
                .mapToLong(matchResultStream ->  Math.max(1, matchResultStream.count()))
                .sum();
    }

    public long countPolySyllables() {
        return words.stream().map(VOWEL_PATTERN::matcher)
                .map(Matcher::results)
                .mapToLong(Stream::count)
                .filter(count -> count > 2)
                .count();
    }

    public double calculateCharsRatePer100Words() {
       return charsCount() * Math.pow(wordsCount(), -1) * 100;
    }

}
