package readability.client;

import readability.scoring.ReadabilityScorer;
import readability.scoring.ScoreSummary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadabilityScore {

    public static void run (String fileName) {
        try {
            var text = Files.readString(Paths.get(fileName));
            ScoreSummary summary = ReadabilityScorer.scoreText(text);
            System.out.printf("Words: %d%n", summary.getWordsCount());
            System.out.printf("Sentences: %d%n", summary.getSentencesCount());
            System.out.printf("Characters: %d%n", summary.getCharsCount());
            System.out.printf("The score is: %.2f%n", summary.getReadabilityIndex());
            System.out.printf("This text should be understood by %s year olds", summary.getGradeLevel());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
