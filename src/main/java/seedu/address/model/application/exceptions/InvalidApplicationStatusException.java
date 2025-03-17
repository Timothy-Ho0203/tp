package seedu.address.model.application.exceptions;

/**
 * Signals that the application status exceeds the number of job rounds.
 */
public class InvalidApplicationStatusException extends RuntimeException {
    public InvalidApplicationStatusException() {
        super("Application status cannot exceed the number of job rounds");
    }
}