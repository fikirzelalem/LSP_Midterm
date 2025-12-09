package org.howard.edu.lsp.finale.question1;

/**
 * Provides a central service for generating passwords using different
 * algorithms. This class implements the Singleton pattern to ensure that
 * only one shared instance exists, and uses the Strategy pattern to allow
 * dynamically swappable password-generation behaviors.
 */
public class PasswordGeneratorService {

    private static PasswordGeneratorService instance = null;
    private PasswordAlgorithm algorithm;

    /* ================================================================
     * DESIGN PATTERN DOCUMENTATION — PART C
     *
     * 1. Design Patterns Used:
     *    • Singleton Pattern
     *    • Strategy Pattern
     *
     * 2. Why These Patterns Are Appropriate:
     *
     *    Singleton:
     *    The system must provide a single shared access point for password
     *    generation. The Singleton pattern enforces this by preventing
     *    external construction and ensuring that getInstance() returns the
     *    only service instance for the entire application.
     *
     *    Strategy:
     *    The password-generation behavior must be swappable, support
     *    multiple algorithms, and allow future expansion without modifying
     *    client code. The Strategy pattern enables each algorithm to be
     *    encapsulated in its own class implementing a common interface,
     *    while the service selects among them at run time.
     *
     *    These patterns together satisfy all architectural expectations:
     *    flexible behavior selection, future scalability, and a globally
     *    shared service instance.
     * ================================================================ */

    /**
     * Private constructor to enforce the Singleton pattern.
     */
    private PasswordGeneratorService() {}

    /**
     * Returns the single shared instance of this service.
     *
     * @return the global PasswordGeneratorService instance
     */
    public static synchronized PasswordGeneratorService getInstance() {
        if (instance == null) {
            instance = new PasswordGeneratorService();
        }
        return instance;
    }

    /**
     * Selects the password generation algorithm to use for subsequent calls.
     * @param name  the algorithm name ("basic", "enhanced", or "letters")
     * @throws IllegalArgumentException if an unknown algorithm name is supplied
     */
    
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

    /**
     * Generates a password using the currently selected algorithm.
     *
     * @param length  the desired password length
     * @return the generated password
     * @throws IllegalStateException if no algorithm has been selected
     */
    public String generatePassword(int length) {
        if (algorithm == null) {
            throw new IllegalStateException("Algorithm must be selected before generating a password.");
        }
        return algorithm.generate(length);
    }
}
