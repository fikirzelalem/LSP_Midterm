package org.howard.edu.lsp.finale.question1;

/**
 * Password generator service using Singleton + Strategy patterns.
 *
 * DESIGN PATTERN DOCUMENTATION:
 * -----------------------------------------
 * 1. Singleton Pattern:
 *    - Ensures only ONE instance of the PasswordGeneratorService exists.
 *    - Required because the assignment states there must be a single shared access point.
 *
 * 2. Strategy Pattern:
 *    - Each password algorithm is its own class implementing PasswordAlgorithm.
 *    - setAlgorithm() allows swapping algorithms at runtime.
 *    - Supports future expansion without modifying client code.
 */
public class PasswordGeneratorService {

    private static PasswordGeneratorService instance = null;
    private PasswordAlgorithm algorithm = null;

    private PasswordGeneratorService() {}

    public static PasswordGeneratorService getInstance() {
        if (instance == null) {
            instance = new PasswordGeneratorService();
        }
        return instance;
    }

    public void setAlgorithm(String name) {
        switch (name.toLowerCase()) {
            case "basic":
                algorithm = new BasicPasswordAlgorithm();
                break;
            case "enhanced":
                algorithm = new EnhancedPasswordAlgorithm();
                break;
            case "letters":
                algorithm = new LettersPasswordAlgorithm();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
    }

    public String generatePassword(int length) {
        if (algorithm == null) {
            throw new IllegalStateException("Algorithm not set.");
        }
        return algorithm.generate(length);
    }
}
