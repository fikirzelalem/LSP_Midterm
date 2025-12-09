package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Generates passwords containing uppercase letters, lowercase letters,
 * and digits. This implementation uses {@link java.security.SecureRandom}
 * for stronger randomization suitable for enhanced password generation.
 */

public class EnhancedPasswordAlgorithm implements PasswordAlgorithm {

    private static final String ALLOWED =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789";

    private SecureRandom random = new SecureRandom();

    /**
     * Generates a password with characters from A–Z, a–z, or 0–9.
     * @param length  number of characters to include in the password
     * @return a mixed alphanumeric password
     */

    @Override
    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALLOWED.length());
            sb.append(ALLOWED.charAt(index));
        }
        return sb.toString();
    }
}
