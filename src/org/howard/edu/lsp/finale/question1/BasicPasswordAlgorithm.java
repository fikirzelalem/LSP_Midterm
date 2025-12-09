package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Generates passwords containing digits only (0–9). This implementation uses
 * {@link java.util.Random} to select the characters from the allowed digit set.
 */

public class BasicPasswordAlgorithm implements PasswordAlgorithm {

    private static final String DIGITS = "0123456789";
    private Random random = new Random();

    /**
     * Generates a numeric password of the given length.
     * @param length  number of digits to include in the password
     * @return a string consisting of digits only
     */
    @Override
    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DIGITS.length());
            sb.append(DIGITS.charAt(index));
        }
        return sb.toString();
    }
}
