package seedu.address.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a job title in a {@Code Job}.
 */
public class JobTitle {
    public static final String MESSAGE_CONSTRAINTS = "Job title should only contain alphanumeric "
            + "characters and spaces, and it should not be blank";

    /**
     * The first character of the job title must not be a whitespace, otherwise " "
     * (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String jobTitle;

    /**
     * Constructs a {@code JobTitle}.
     *
     * @param jobTitle A valid job title.
     */
    public JobTitle(String jobTitle) {
        requireNonNull(jobTitle);
        checkArgument(isValidJobTitle(jobTitle), MESSAGE_CONSTRAINTS);
        this.jobTitle = jobTitle;
    }

    /**
     * Returns true if a given string is a valid job title.
     *
     * @param test The string to validate.
     * @return True if the given string is a valid job title.
     */
    public static boolean isValidJobTitle(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the string representation of this job title.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return jobTitle;
    }

    /**
     * Returns true if this job title is the same as the specified object.
     *
     * @param other The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof JobTitle)) {
            return false;
        }
        JobTitle otherJobTitle = (JobTitle) other;
        return jobTitle.equals(otherJobTitle.jobTitle);
    }

    /**
     * Returns the hash code of this job title.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return jobTitle.hashCode();
    }
}
