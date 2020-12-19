package readability.scoring;


public class ScoreSummary {
    private final int wordsCount;
    private final int sentencesCount;
    private final int charsCount;
    private final double readabilityIndex;
    private final GradeLevel gradeLevel;

    public ScoreSummary(int wordsCount, int sentencesCount, int charsCount, double readabilityIndex, GradeLevel gradeLevel) {
        this.wordsCount = wordsCount;
        this.sentencesCount = sentencesCount;
        this.charsCount = charsCount;
        this.readabilityIndex = readabilityIndex;
        this.gradeLevel = gradeLevel;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public int getSentencesCount() {
        return sentencesCount;
    }

    public int getCharsCount() {
        return charsCount;
    }

    public double getReadabilityIndex() {
        return readabilityIndex;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

}
