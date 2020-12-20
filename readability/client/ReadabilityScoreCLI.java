package readability.client;

import readability.scoring.strategies.ReadabilityScoreContext;
import readability.scoring.rates.CharsRate;
import readability.scoring.rates.WordsRate;
import readability.scoring.strategies.AutomatedReadabilityIndex;
import readability.scoring.strategies.ColemanLiauIndex;
import readability.scoring.strategies.FleshKincaidTests;
import readability.scoring.strategies.GoobbledygookSimpleMeasure;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ReadabilityScoreCLI {
    private final static String SENTENCE_REGEX = "(?<=[.!?])."; //Look Behind technique
    private final static ReadabilityScoreContext SCORE_CONTEXT = new ReadabilityScoreContext();

    public static void run (String fileName) {
        try {
            var text = Files.readString(Paths.get(fileName));
            var sentences = text.split(SENTENCE_REGEX);
            var wordsRate = new WordsRate(Arrays.asList(sentences));
            var charsRate = new CharsRate(wordsRate.getWords());

            System.out.printf("Words: %d%n", charsRate.wordsCount());
            System.out.printf("Sentences: %d%n", wordsRate.sentencesCount());
            System.out.printf("Characters: %d%n", charsRate.charsCount());
            System.out.printf("Syllables: %d%n", charsRate.countSyllables());
            System.out.printf("PolySyllables: %d%n", charsRate.countPolySyllables());
            System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all)");
            var scanner = new Scanner(System.in);

            var option = scanner.nextLine();
            switch (option) {
                case "ARI":
                        printARIScore(wordsRate, charsRate);
                    break;
                case "FK":
                        printFKScore(wordsRate, charsRate);
                    break;
                case "SMOG":
                        printSMOGScore(wordsRate, charsRate);
                    break;
                case "CL":
                        printCLScore(wordsRate, charsRate);
                    break;
                default:
                        printAllScores(wordsRate, charsRate);
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAllScores(WordsRate wordsRate, CharsRate charsRate) {
        printARIScore(wordsRate, charsRate);
        printFKScore(wordsRate, charsRate);
        printSMOGScore(wordsRate, charsRate);
        printCLScore(wordsRate, charsRate);
    }

    private static void printCLScore(WordsRate wordsRate, CharsRate charsRate) {
        SCORE_CONTEXT.setStrategy(new ColemanLiauIndex());
        System.out.printf("Coleman–Liau index: %s%n", SCORE_CONTEXT.calculateReadabilityScore(wordsRate, charsRate));
    }

    private static void printSMOGScore(WordsRate wordsRate, CharsRate charsRate) {
        SCORE_CONTEXT.setStrategy(new GoobbledygookSimpleMeasure());
        System.out.printf("Simple Measure of Gobbledygook: %s%n", SCORE_CONTEXT.calculateReadabilityScore(wordsRate, charsRate));
    }

    private static void printFKScore(WordsRate wordsRate, CharsRate charsRate) {
        SCORE_CONTEXT.setStrategy(new FleshKincaidTests());
        System.out.printf("Flesch–Kincaid readability tests: %s%n", SCORE_CONTEXT.calculateReadabilityScore(wordsRate, charsRate));
    }

    private static void printARIScore(WordsRate wordsRate, CharsRate charsRate) {
        SCORE_CONTEXT.setStrategy(new AutomatedReadabilityIndex());
        System.out.printf("Automated Readability Index: %s%n", SCORE_CONTEXT.calculateReadabilityScore(wordsRate, charsRate));
    }
}
