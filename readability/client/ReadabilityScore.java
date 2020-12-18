package readability.client;

import readability.scoring.ReadabilityScorer;

import java.util.Scanner;

public class ReadabilityScore {

    public static void run () {
       var stdin = new Scanner(System.in);
       var text = stdin.nextLine();
       System.out.println(ReadabilityScorer.scoreText(text));
    }
}
