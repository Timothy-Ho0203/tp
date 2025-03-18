package seedu.address.model.application.exceptions;

/**
 * Signals that the operation is unable to find the specified application.
 */
public class ApplicationNotFoundException extends RuntimeException {
    public ApplicationNotFoundException() {
        super("Application not found");
    }
}
