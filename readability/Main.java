package readability;

import readability.client.ReadabilityScoreCLI;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            ReadabilityScoreCLI.run(args[0]);
        } else {
            throw new IllegalArgumentException("Input an input text file");
        }
    }
}
