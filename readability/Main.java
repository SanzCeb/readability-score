package readability;

import readability.client.ReadabilityScore;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            ReadabilityScore.run(args[0]);
        } else {
            throw new IllegalArgumentException("Input an input text file");
        }
    }
}
