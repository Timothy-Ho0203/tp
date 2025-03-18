package seedu.address.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the number of interview rounds in a {@Code Job}.
 */
public class JobRounds {
    public static final String MESSAGE_CONSTRAINTS = "Job rounds should be a positive integer";

    /**
     * The number of rounds must be a positive integer.
     */
    public static final String VALIDATION_REGEX = "^[1-9]\\d*$";
    public final int jobRounds;

    /**
     * Constructs a {@code JobRounds}.
     *
     * @param rounds A valid number of job rounds.
     */
    public JobRounds(int rounds) {
        requireNonNull(rounds);
        checkArgument(isValidJobRounds(rounds), MESSAGE_CONSTRAINTS);
        this.jobRounds = rounds;
    }

    /**
     * Constructs a {@code JobRounds} from a string.
     *
     * @param rounds A valid number of job rounds as a string.
     */
    public JobRounds(String rounds) {
        requireNonNull(rounds);
        checkArgument(isValidJobRounds(rounds), MESSAGE_CONSTRAINTS);
        this.jobRounds = Integer.parseInt(rounds);
    }

    /**
     * Returns true if a given integer is a valid number of job rounds.
     *
     * @param test The integer to validate.
     * @return True if the given integer is a valid number of job rounds.
     */
    public static boolean isValidJobRounds(int test) {
        return test > 0;
    }

    /**
     * Returns true if a given string is a valid number of job rounds.
     *
     * @param test The string to validate.
     * @return True if the given string is a valid number of job rounds.
     */
    public static boolean isValidJobRounds(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the string representation of the number of job rounds.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return String.valueOf(jobRounds);
    }

    /**
     * Returns true if this job rounds is the same as the specified object.
     *
     * @param other The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof JobRounds)) {
            return false;
        }
        JobRounds otherJobRounds = (JobRounds) other;
        return jobRounds == otherJobRounds.jobRounds;
    }

    /**
     * Returns the hash code of this job rounds.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(jobRounds);
    }
}
