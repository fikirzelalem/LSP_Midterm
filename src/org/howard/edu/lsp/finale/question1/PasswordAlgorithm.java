package org.howard.edu.lsp.finale.question1;

/**
 * Defines the common behavior for all password generation algorithms.
 * Each algorithm implementing this interface must provide a mechanism
 * for generating a password string of a specified length.
 */
public interface PasswordAlgorithm {

    /**
     * Generates a password of the specified length.
     * @param length  the number of characters the generated password must contain
     * @return the generated password as a String
     */
    String generate(int length);
}
