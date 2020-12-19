package readability.scoring;

public class ReadabilityScorer {
    private final static String SENTENCE_REGEX = "(?<=[.!?])."; //Look Behind technique

    public static ScoreSummary scoreText(String text) {
        var sentences = text.split(SENTENCE_REGEX);
        var automatedReadabilityIndex = new AutomatedReadabilityIndex(sentences);
        int wordsCount = automatedReadabilityIndex.countWords();
        int charsCount = automatedReadabilityIndex.countChars();
        int sentencesCount = automatedReadabilityIndex.countSentences();
        double index = automatedReadabilityIndex.calculateScore();
        int age = roundIndex(index);
        var gradeLevel = GradeLevel.getGradeLevel(age);
        return new ScoreSummary(wordsCount, sentencesCount, charsCount, index, gradeLevel);
    }

    private static int roundIndex(double index) {
        return (int)Math.ceil(index);
    }

}
