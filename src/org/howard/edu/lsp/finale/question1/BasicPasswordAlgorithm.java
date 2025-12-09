package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Generates passwords using digits only, via java.util.Random.
 */
public class BasicPasswordAlgorithm implements PasswordAlgorithm {

    private static final String DIGITS = "0123456789";
    private Random random = new Random();

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(DIGITS.length());
            sb.append(DIGITS.charAt(idx));
        }
        return sb.toString();
    }
}
