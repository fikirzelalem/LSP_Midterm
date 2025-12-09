package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Password algorithm that uses SecureRandom and includes letters + digits.
 */
public class EnhancedPasswordAlgorithm implements PasswordAlgorithm {

    private static final String ALLOWED =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz" +
        "0123456789";

    private SecureRandom random = new SecureRandom();

    public String generate(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(ALLOWED.length());
            sb.append(ALLOWED.charAt(idx));
        }
        return sb.toString();
    }
}
