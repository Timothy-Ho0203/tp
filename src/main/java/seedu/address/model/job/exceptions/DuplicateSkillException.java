package seedu.address.model.job.exceptions;

/**
 * Signals that the operation will result in duplicate Skills (Skills are
 * considered duplicates if they have the same identity).
 */
public class DuplicateSkillException extends RuntimeException {
    public DuplicateSkillException() {
        super("Operation would result in duplicate skills");
    }
}
