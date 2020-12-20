package readability.scoring.rates;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsRate {
    private final static String WHITESPACES = "\\s+";
    private final List<String> sentences;

    public WordsRate(List<String> sentences) {
        this.sentences = sentences;
    }

    public List<String> getWords() {
        return sentences.stream()
                .flatMap(WordsRate::splitSentence)
                .collect(Collectors.toList());
    }

    public int sentencesCount() {
        return sentences.size();
    }

    public double calculateWordsRate() {
        return sentences.stream()
                .map(WordsRate::splitSentence)
                .mapToLong(Stream::count)
                .average()
                .orElse(0);
    }

    private static Stream<String> splitSentence (String sentence) {
        return Stream.of(sentence.trim().split(WHITESPACES));
    }

    public double sentencesRatePer100Words() {
        return sentencesCount() * Math.pow( getWords().size() , - 1) * 100;
    }

}
