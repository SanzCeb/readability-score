package readability.scoring;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReadabilityScorer {
    private final static String SENTENCE_REGEX = "[.!?]";
    private final static String WHITESPACES = "\\s+";

    public static Score scoreText(String text) {

        var sentences = splitSentences(text);
        var sentencesNumWords = countNumWordsPerSentence(sentences);
        var wordsLengthAvg = calculateWordsCountAvg(sentencesNumWords);

        return wordsLengthAvg > 10 ? Score.HARD : Score.EASY;
    }

    private static double calculateWordsCountAvg (IntStream numWordsPerSentence) {
        return numWordsPerSentence.average().orElse(0);
    }

    private static IntStream countNumWordsPerSentence(String[] sentences) {
        return Stream.of(sentences)
                .mapToInt(ReadabilityScorer::countWords);
    }

    private static int countWords (String sentence) {
        return splitSentence(sentence).length;
    }

    private static String[] splitSentence (String sentence) {
        return sentence.trim().split(WHITESPACES);
    }

    private static String[] splitSentences(String text) {
        return text.split(SENTENCE_REGEX);
    }

}
