package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Generates letters-only passwords using SecureRandom.
 */
public class LettersPasswordAlgorithm implements PasswordAlgorithm {

    private static final String LETTERS =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private SecureRandom random = new SecureRandom();

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(idx));
        }
        return sb.toString();
    }
}
