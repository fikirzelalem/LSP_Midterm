package org.howard.edu.lsp.finale.question1;

/**
 * Strategy interface for password generation algorithms.
 */
public interface PasswordAlgorithm {
    public String generate(int length);
}
