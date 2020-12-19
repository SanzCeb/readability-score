package readability.scoring.rates;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsRate {
    private final static String WHITESPACES = "\\s+";
    private final Collection<String> sentences;

    public WordsRate(Collection<String> sentences) {
        this.sentences = sentences;
    }

    public Collection<String> getWords() {
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
}
