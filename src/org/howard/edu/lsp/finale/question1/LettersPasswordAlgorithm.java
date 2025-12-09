package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Generates passwords containing letters only (A–Z and a–z).
 * This algorithm is useful when numeric characters are not permitted.
 */

public class LettersPasswordAlgorithm implements PasswordAlgorithm {

    private static final String LETTERS =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private SecureRandom random = new SecureRandom();

    /**
     * Generates a password consisting of alphabetic characters only.
     * @param length  number of letters to include in the password
     * @return a letter-only password string
     */
    
    @Override
    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(LETTERS.length());
            sb.append(LETTERS.charAt(idx));
        }
        return sb.toString();
    }
}
